package br.com.mind5.business.employeeLunchTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public class EmplutmCheckRange extends ModelCheckerTemplateSimple<EmplutmInfo> {
	
	public EmplutmCheckRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplutmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null ||
		     recordInfo.endTime   == null		)
			
			return super.FAILED;
			
		
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_INVALID_RANGE;	
	}
}
