package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class StoreLDateCheckKey extends ModelCheckerTemplate<StoreLDateInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public StoreLDateCheckKey(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreLDateInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 		<= 0 
			 || recordInfo.codStore  		<= 0 
			 || recordInfo.dateValidFrom	== null
			 || recordInfo.timeValidFrom	== null		)			
			return EMPTY_KEY;		
		
		return KEY_NOT_NULL;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.KEY_FIELD_NOT_NULL)
			return SystemMessage.KEY_FIELD_NOT_NULL;
		
		return SystemMessage.KEY_FIELD_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == KEY_NOT_NULL)
			return SystemCode.KEY_FIELD_NOT_NULL;				
		
		return SystemCode.KEY_FIELD_IS_EMPTY;
	}
}
