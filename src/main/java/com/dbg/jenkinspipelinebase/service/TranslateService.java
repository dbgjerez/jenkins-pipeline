package com.dbg.jenkinspipelinebase.service;

import com.dbg.jenkinspipelinebase.dto.TranslationDTO;
import com.dbg.jenkinspipelinebase.dto.TranslationRequestDTO;

public interface TranslateService {

	/**
	 * Traduce de esp al idioma deseado
	 * 
	 * @param rq
	 * @return
	 */
	TranslationDTO translate(TranslationRequestDTO rq);

}
