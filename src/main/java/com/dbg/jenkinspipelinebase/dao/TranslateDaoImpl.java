package com.dbg.jenkinspipelinebase.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.dbg.jenkinspipelinebase.dto.TranslationDTO;
import com.dbg.jenkinspipelinebase.dto.TranslationRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TranslateDaoImpl implements TranslateDao, InitializingBean {

	private static final String DE = "de";
	private static final String EN = "en";
	private static final String HALLO_WELT = "Hallo Welt";
	private static final String HELLO_WORLD = "hello world";
	private static final String HOLA_MUNDO = "hola mundo";
	
	private Map<String, Map<String, String>> bbdd = new HashMap<>();

	@Override
	public TranslationDTO translate(TranslationRequestDTO rq) {
		final String translation = bbdd.get(rq.getLanguage()).get(rq.getText());
		return TranslationDTO.builder().language(rq.getLanguage()).text(translation).build();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("Inicializando BBDD...");
		final Map<String, String> en = new HashMap<>();
		en.put(HOLA_MUNDO, HELLO_WORLD);
		final Map<String, String> de = new HashMap<>();
		de.put(HOLA_MUNDO, HALLO_WELT);
		bbdd.put(EN, en);
		bbdd.put(DE, de);
	}

}
