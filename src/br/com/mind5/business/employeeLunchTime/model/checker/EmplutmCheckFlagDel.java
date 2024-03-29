package br.com.mind5.business.employeeLunchTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmplutmCheckFlagDel extends ModelCheckerTemplateSimple<EmplutmInfo> {

	public EmplutmCheckFlagDel(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplutmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isDeleted )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_MANDATORY_FIELD_EMPTY;
	}
}
