package br.com.gda.business.companySearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.companySearch.info.ComparchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class ComparchCheckRead extends ModelCheckerTemplateSimpleV2<ComparchInfo> {

	public ComparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ComparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codLanguage	== null ||
			 recordInfo.username	== null		)			
			return super.FAILED;		
		
		
		if ( recordInfo.cnpj  			== null &&
			 recordInfo.codEntityCateg	== null		)			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
