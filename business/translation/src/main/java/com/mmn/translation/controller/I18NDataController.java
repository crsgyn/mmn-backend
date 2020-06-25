package com.mmn.translation.controller;

import com.mmn.translation.dto.I18NDto;
import com.mmn.translation.model.I18NData;
import com.mmn.translation.service.I18NDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lang")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class I18NDataController {
    private final I18NDataService service;

    @GetMapping
    @ResponseBody
    public List<I18NData> allData() {
        return this.service.allData();
    }

    @GetMapping("/{lang}")
    @ResponseBody
    public I18NDto by(@PathVariable("lang") final String lang) {
        return this.service.by(lang);
    }

    @PostMapping("/one")
    @ResponseBody
    public I18NData saveOne(@RequestBody final I18NData data) {
        return this.service.saveOne(data);
    }

    @PostMapping("/many")
    @ResponseBody
    public List<I18NData> saveMany(@RequestBody final I18NDto dto) {
        return this.service.saveMany(dto);
    }

    @DeleteMapping("/one")
    @ResponseBody
    public String deleteOne(@RequestBody final I18NData data) {
        return this.service.deleteOne(data);
    }

    @DeleteMapping("/many")
    @ResponseBody
    public List<String> deleteMany(@RequestBody final I18NDto dto) {
        return this.service.deleteMany(dto);
    }
}
