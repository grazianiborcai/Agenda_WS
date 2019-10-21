package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public class CurrencyCheckRead extends ModelCheckerTemplateSimple_<CurrencyInfo> {

	public CurrencyCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CurrencyInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CURRENCY_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CURRENCY_MANDATORY_FIELD_EMPTY;
	}
}
