package br.com.mind5.payment.countryPartnerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparchCheckRead extends ModelCheckerTemplateSimple<CounparchInfo> {

	public CounparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CounparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner <= 0 		||
			 recordInfo.codCountry	  == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_COUNTRY_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
