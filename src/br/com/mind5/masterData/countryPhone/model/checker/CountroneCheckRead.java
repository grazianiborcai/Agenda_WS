package br.com.mind5.masterData.countryPhone.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CountroneCheckRead extends ModelCheckerTemplateSimpleV2<CountroneInfo> {

	public CountroneCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CountroneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountryPhone	<= 0 	||
			 recordInfo.codLanguage 	== null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_PHONE_MANDATORY_FIELD_EMPTY;
	}
}
