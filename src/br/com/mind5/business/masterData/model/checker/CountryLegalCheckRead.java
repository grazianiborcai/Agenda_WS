package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CountryLegalCheckRead extends ModelCheckerTemplateSimple_<CountryLegalInfo> {

	public CountryLegalCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CountryLegalInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COUNTRY_LEGAL_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COUNTRY_LEGAL_MANDATORY_FIELD_EMPTY;
	}
}
