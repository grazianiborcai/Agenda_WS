package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreCheckKey extends ModelCheckerTemplateSimple<StoreInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public StoreCheckKey(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (  recordInfo.codOwner  		>= 0	&& 
			  recordInfo.codStore  		>= 0	&&
			  recordInfo.codLanguage 	!= null		)			
			return KEY_NOT_NULL;		
		
		return EMPTY_KEY;
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
