package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompCheckUpdate extends ModelCheckerTemplateSimpleV2<CompInfo> {

	public CompCheckUpdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0	||
			 recordInfo.codCompany 		<= 0	||
			 recordInfo.username		== null	||
			 recordInfo.codLanguage		== null	||
			 recordInfo.name 			== null	||
			 recordInfo.codCountryLegal	== null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_MANDATORY_FIELD_EMPTY;
	}
}
