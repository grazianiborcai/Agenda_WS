package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class StoreCheckGenField extends ModelCheckerTemplate<StoreInfo> {
	private final boolean AUTO_GEN_FIELD_NOT_NULL = false;
	private final boolean EMPTY_AUTO_GEN_FIELD = true;
	
	public StoreCheckGenField() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codStore >= 0 )			
			return AUTO_GEN_FIELD_NOT_NULL;		
		
		return EMPTY_AUTO_GEN_FIELD;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
}
