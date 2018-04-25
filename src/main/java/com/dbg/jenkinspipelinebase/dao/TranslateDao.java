package com.dbg.jenkinspipelinebase.dao;

public interface TranslateDao {

	/**
	 * Recibe en lowercase un texto a traducir
	 * 
	 * @param language
	 *            idioma en el que traducir (en, de)
	 * @param text
	 * @return
	 */
	String translate(String language, String text);

}
