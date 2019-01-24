package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreCheckHasPhone extends ModelCheckerTemplateSimple<StoreInfo> {
	
	public StoreCheckHasPhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null || recordInfo.phones.isEmpty())			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PHONE_IS_NULL)
			return SystemMessage.PHONE_IS_NULL;
		
		return SystemMessage.PHONE_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PHONE_IS_FILLED;	
			
		return SystemCode.PHONE_IS_NULL;
	}
}
