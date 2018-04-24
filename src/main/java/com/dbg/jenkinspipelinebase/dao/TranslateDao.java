package com.dbg.jenkinspipelinebase.dao;

import com.dbg.jenkinspipelinebase.dto.TranslationDTO;
import com.dbg.jenkinspipelinebase.dto.TranslationRequestDTO;

public interface TranslateDao {

	TranslationDTO translate(TranslationRequestDTO rq);

}
