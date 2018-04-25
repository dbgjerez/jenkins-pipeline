package com.dbg.jenkinspipelinebase.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TranslationRequestDTO implements Serializable {

	private static final long serialVersionUID = 5666862072082525898L;

	private String language;
	private String text;

}
