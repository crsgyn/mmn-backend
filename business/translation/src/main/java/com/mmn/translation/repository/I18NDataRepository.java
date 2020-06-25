package com.mmn.translation.repository;

import com.mmn.translation.model.I18NData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface I18NDataRepository extends JpaRepository<I18NData, String> {
    List<I18NData> findAllByLanguageIgnoreCase(final String language);

    Optional<I18NData> findByLanguageAndKeyIgnoreCase(final String language, final String key);
}
