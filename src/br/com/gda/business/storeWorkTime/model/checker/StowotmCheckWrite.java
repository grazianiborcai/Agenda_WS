package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StowotmCheckWrite extends ModelCheckerTemplateSimpleV2<StowotmInfo> {

	public StowotmCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StowotmInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codWeekday	<= 0
			|| recordInfo.codLanguage	== null
			|| recordInfo.username		== null
			|| recordInfo.beginTime		== null
			|| recordInfo.endTime		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_MANDATORY_FIELD_EMPTY;
	}
}
