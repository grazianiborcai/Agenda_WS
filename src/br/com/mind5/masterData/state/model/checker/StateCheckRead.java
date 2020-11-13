package br.com.mind5.masterData.state.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StateCheckRead extends ModelCheckerTemplateSimple<StateInfo> {

	public StateCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StateInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null ||
			 recordInfo.codCountry  == null ||
			 recordInfo.codState    == null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_MANDATORY_FIELD_EMPTY;
	}
}
