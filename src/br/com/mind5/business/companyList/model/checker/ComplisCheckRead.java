package br.com.mind5.business.companyList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class ComplisCheckRead extends ModelCheckerTemplateSimpleV2<ComplisInfo> {

	public ComplisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ComplisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codCompany 	<= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)		
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() { 
		return SystemCode.COMPANY_LIST_MANDATORY_FIELD_EMPTY;
	}
}
