package br.com.mind5.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StolateCheckDeleteByStore extends ModelCheckerTemplateSimpleV2<StolateInfo> {

	public StolateCheckDeleteByStore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolateInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.codStore			<= 0
			|| recordInfo.codLanguage		== null	
			|| recordInfo.username			== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_MANDATORY_FIELD_EMPTY;
	}
}
