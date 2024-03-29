package br.com.mind5.business.storeLunchTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StuntmCheckRange extends ModelCheckerTemplateSimple<StuntmInfo> {

	public StuntmCheckRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StuntmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null || 
			 recordInfo.endTime	  == null	)
			
			return super.FAILED;
		
		
		if (recordInfo.endTime.isBefore(recordInfo.beginTime))
			return super.FAILED;
		
		if (recordInfo.endTime.equals(recordInfo.beginTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_BAD_TIME_RANGE;
	}
}
