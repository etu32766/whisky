package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.entity.TranslationEntity;
import com.whisky.henallux.whisky.dataAccess.repository.TranslationRepository;
import com.whisky.henallux.whisky.dataAccess.util.ProviderConverter;
import com.whisky.henallux.whisky.model.Language;
import com.whisky.henallux.whisky.model.Translation;
import com.whisky.henallux.whisky.model.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class TranslationDAO {

    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter providerConverter)
    {
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    public Translation getTranslationByWhiskyidAndLanguageid(Whisky whiskyid, Language languageid)
    {
        TranslationEntity translationEntity = translationRepository.findByWhiskyidAndAndLanguageid(providerConverter.whiskyToWhiskyEntity(whiskyid), providerConverter.languageToLanguageEntity(languageid));
        return providerConverter.translationEntityToTranslation(translationEntity);
    }


}
