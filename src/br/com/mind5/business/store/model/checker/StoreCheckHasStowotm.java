package br.com.mind5.business.store.model.checker;

import java.sql.Connection;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoreCheckHasStowotm extends ModelCheckerTemplateSimple<StoreInfo> {
	
	public StoreCheckHasStowotm(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.stowotmes == null)			
			return super.FAILED;		
		
		if (recordInfo.stowotmes.isEmpty())			
			return super.FAILED;			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_MANDATORY_FIELD_EMPTY;
	}
}
