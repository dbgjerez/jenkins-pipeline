package com.dbg.jenkinspipelinebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbg.jenkinspipelinebase.dao.TranslateDao;
import com.dbg.jenkinspipelinebase.dto.TranslationDTO;
import com.dbg.jenkinspipelinebase.dto.TranslationRequestDTO;

@Service
public class TranslateServiceImpl implements TranslateService {

	@Autowired
	TranslateDao dao;

	@Override
	public TranslationDTO translate(TranslationRequestDTO rq) {
		final String language = rq.getLanguage();
		final String txt = rq.getText().toLowerCase();
		final String translate = dao.translate(language, txt);
		return TranslationDTO.builder().text(translate).language(language).build();
	}

}
