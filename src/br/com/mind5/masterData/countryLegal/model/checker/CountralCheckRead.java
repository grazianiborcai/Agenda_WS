package br.com.mind5.masterData.countryLegal.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CountralCheckRead extends ModelCheckerTemplateSimpleV2<CountralInfo> {

	public CountralCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CountralInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry  == null ||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_LEGAL_MANDATORY_FIELD_EMPTY;
	}
}
