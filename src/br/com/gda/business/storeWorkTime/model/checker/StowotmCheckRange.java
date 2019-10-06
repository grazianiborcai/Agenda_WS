package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StowotmCheckRange extends ModelCheckerTemplateSimpleV2<StowotmInfo> {

	public StowotmCheckRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StowotmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null || 
			 recordInfo.endTime	  == null	)
			
			return super.FAILED;
		
		
		if (recordInfo.endTime.isBefore(recordInfo.beginTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_BAD_TIME_RANGE;
	}
}
