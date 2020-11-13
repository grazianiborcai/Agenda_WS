package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmposCheckWrite extends ModelCheckerTemplateSimple<EmposInfo> {

	public EmposCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmposInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||	
			 recordInfo.codStore 	<= 0 	||
			 recordInfo.codEmployee	<= 0	||  	
			 recordInfo.codPosition	<= 0	||
			 recordInfo.codLanguage	== null	||	
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_MANDATORY_FIELD_EMPTY;
	}
}
