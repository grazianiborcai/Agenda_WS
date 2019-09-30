package br.com.gda.business.personSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.personSearch.info.PerarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PerarchCheckRead extends ModelCheckerTemplateSimpleV2<PerarchInfo> {

	public PerarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PerarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
			return super.FAILED;		
		
		
		if ( recordInfo.codPerson 	<= 0 	&&
			 recordInfo.cpf			== null	&&
			 recordInfo.email		== null		)			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
