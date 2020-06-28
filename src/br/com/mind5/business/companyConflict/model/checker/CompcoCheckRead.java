package br.com.mind5.business.companyConflict.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompcoCheckRead extends ModelCheckerTemplateSimpleV2<CompcoInfo> {

	public CompcoCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompcoInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  		<= 0 	||
			 recordInfo.codCompany  	<= 0 	||
			 recordInfo.cnpj  			== null ||
			 recordInfo.codEntityCateg	== null	||
			 recordInfo.codLanguage		== null ||
			 recordInfo.username		== null		)	
			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CONFLICT_MANDATORY_FIELD_EMPTY;
	}
}
