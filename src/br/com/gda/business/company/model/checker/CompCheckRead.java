package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompCheckRead extends ModelCheckerTemplateSimpleV2<CompInfo> {

	public CompCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codCompany 	<= 0	||
			 recordInfo.codLanguage	== null ||
			 recordInfo.username	== null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_MANDATORY_FIELD_EMPTY;
	}
}
