package br.com.mind5.business.personList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PersolisCheckRead extends ModelCheckerTemplateSimpleV2<PersolisInfo> {

	public PersolisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersolisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codPerson 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_LIST_MANDATORY_FIELD_EMPTY;
	}
}
