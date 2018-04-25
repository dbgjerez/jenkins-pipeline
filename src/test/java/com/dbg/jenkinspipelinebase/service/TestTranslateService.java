package com.dbg.jenkinspipelinebase.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dbg.jenkinspipelinebase.dao.TranslateDao;
import com.dbg.jenkinspipelinebase.dto.TranslationDTO;
import com.dbg.jenkinspipelinebase.dto.TranslationRequestDTO;

@RunWith(MockitoJUnitRunner.class)
public class TestTranslateService {

	private static final String TRANSLATION = "hello world";
	private static final String TEXT = "hOlA Mundo";
	private static final String EN = "en";

	@Mock
	private TranslateDao dao;

	@InjectMocks
	private TranslateService service = new TranslateServiceImpl();

	@Test
	public void testTranslate() {
		final TranslationRequestDTO t = TranslationRequestDTO.builder().language(EN).text(TEXT).build();
		Mockito.when(dao.translate(EN, TEXT.toLowerCase())).thenReturn(TRANSLATION);
		final TranslationDTO translate = service.translate(t);
		Assert.assertEquals(translate.getText(), TRANSLATION);
	}

}
