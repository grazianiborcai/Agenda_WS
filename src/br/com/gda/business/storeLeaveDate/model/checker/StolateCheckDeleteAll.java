package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StolateCheckDeleteAll extends ModelCheckerTemplateSimpleV2<StolateInfo> {
	
	public StolateCheckDeleteAll(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolateInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.username		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_LDATE_MANDATORY_FIELD_EMPTY;
	}
}
