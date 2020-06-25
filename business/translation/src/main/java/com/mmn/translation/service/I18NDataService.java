package com.mmn.translation.service;

import com.google.common.collect.Lists;
import com.mmn.translation.dto.I18NDto;
import com.mmn.translation.model.I18NData;
import com.mmn.translation.repository.I18NDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class I18NDataService {
    private final I18NDataRepository repository;
    private final String DELETE_FAIL = "DELETE_FAIL";
    private final String DELETE_SUCCESS = "DELETE_SUCCESS";

    public List<I18NDto> allDto() {
        final Map<String, List<I18NData>> groupBy = this.allData().stream().collect(groupingBy(I18NData::getLanguage));
        return groupBy.entrySet().stream().map((entry) -> dataList2dto(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

    public List<I18NData> allData() {
        return this.repository.findAll();
    }


    public I18NDto by(final String lang) {
        if (Objects.isNull(lang)) {
            return null;
        }
        return this.dataList2dto(lang, this.repository.findAllByLanguageIgnoreCase(lang));
    }

    public I18NData saveOne(final I18NData data) {
        if (Objects.isNull(data.getLanguage()) || Objects.isNull(data.getKey())) {
            return null;
        }
        checkAndDoIfExists(data, (id) -> data.setId(id));
        return this.repository.save(data);
    }

    public String deleteOne(final I18NData data) {
        if (Objects.isNull(data.getLanguage()) || Objects.isNull(data.getKey())) {
            return DELETE_FAIL;
        }

        final boolean idIfExists = checkAndDoIfExists(data, (id) -> {
            data.setId(id);
            this.repository.delete(data);
        });

        return idIfExists ? DELETE_SUCCESS : DELETE_FAIL;
    }

    public List<I18NData> saveMany(final I18NDto i18NDto) {
        if (Objects.isNull(i18NDto)) {
            return new ArrayList<>();
        }
        return this.saveMany(dto2dataList(i18NDto));
    }

    private List<I18NData> saveMany(final List<I18NData> dataList) {
        if (Objects.isNull(dataList) || dataList.isEmpty()) {
            return new ArrayList<>();
        }
        return dataList.stream().map(this::saveOne).collect(Collectors.toList());
    }

    public List<String> deleteMany(final I18NDto i18NDto) {
        if (Objects.isNull(i18NDto)) {
            return Lists.newArrayList(DELETE_FAIL);
        }

        return this.deleteMany(dto2dataList(i18NDto));
    }

    private List<String> deleteMany(final List<I18NData> dataList) {
        if (Objects.isNull(dataList) || dataList.isEmpty()) {
            return new ArrayList<>();
        }
        return dataList.stream().map(this::deleteOne).collect(Collectors.toList());
    }

    private boolean checkAndDoIfExists(final I18NData data, Consumer<String> consumer) {
        final Optional<I18NData> optionalI18NData = this.repository.findByLanguageAndKeyIgnoreCase(data.getLanguage(), data.getKey());
        if (optionalI18NData.isPresent()) {
            consumer.accept(optionalI18NData.get().getId());
            return true;
        }
        return false;
    }

    // Helpers
    private List<I18NData> dto2dataList(final I18NDto i18NDto) {
        return i18NDto.getDictionary().entrySet().stream()
                .map(entry -> I18NData.builder()
                        .language(i18NDto.getLocale())
                        .key(entry.getKey())
                        .value(entry.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    private I18NDto dataList2dto(final String lang, final List<I18NData> list) {
        return I18NDto.builder()
                .locale(lang)
                .dictionary(list.stream().collect(Collectors.toMap(I18NData::getKey, I18NData::getValue)))
                .build();
    }
}
