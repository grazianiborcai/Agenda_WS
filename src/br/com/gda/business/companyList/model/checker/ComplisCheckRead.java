package br.com.gda.business.companyList.model.checker;

import java.sql.Connection;

import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class ComplisCheckRead extends ModelCheckerTemplateSimpleV2<ComplisInfo> {

	public ComplisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ComplisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codLanguage == null		)		
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() { 
		return SystemCode.COMPANY_LIST_MANDATORY_FIELD_EMPTY;
	}
}
