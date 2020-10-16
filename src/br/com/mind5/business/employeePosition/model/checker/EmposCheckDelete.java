package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmposCheckDelete extends ModelCheckerTemplateSimpleV2<EmposInfo> {
	public EmposCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmposInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	|| 
			 recordInfo.codStore  	<= 0	|| 
			 recordInfo.codEmployee	<= 0	||
			 recordInfo.codPosition	<= 0	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_MANDATORY_FIELD_EMPTY;
	}
}
