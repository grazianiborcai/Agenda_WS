package br.com.mind5.business.store.model.checker;

import java.sql.Connection;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoreCheckHasComp extends ModelCheckerTemplateSimpleV2<StoreInfo> {
	
	public StoreCheckHasComp(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.companyData == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook(){
		return SystemCode.STORE_COMPANY_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_COMPANY_IS_EMPTY;
	}
}
