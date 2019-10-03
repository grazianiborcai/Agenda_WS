package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoreCheckHasPerson extends ModelCheckerTemplateSimpleV2<StoreInfo> {
	
	public StoreCheckHasPerson(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.personData == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook(){
		return SystemCode.STORE_PERSON_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_PERSON_IS_EMPTY;
	}
}
