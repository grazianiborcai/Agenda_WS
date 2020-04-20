package br.com.mind5.masterData.country.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CountryCheckRead extends ModelCheckerTemplateSimpleV2<CountryInfo> {

	public CountryCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CountryInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry  == null ||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_MANDATORY_FIELD_EMPTY;
	}
}
