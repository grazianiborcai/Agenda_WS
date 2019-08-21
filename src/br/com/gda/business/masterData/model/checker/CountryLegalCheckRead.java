package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CountryLegalCheckRead extends ModelCheckerTemplateSimple<CountryLegalInfo> {

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
