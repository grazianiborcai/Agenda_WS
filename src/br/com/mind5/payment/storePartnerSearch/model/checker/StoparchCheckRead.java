package br.com.mind5.payment.storePartnerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoparchCheckRead extends ModelCheckerTemplateSimpleV2<StoparchInfo> {

	public StoparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoparchInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    	<= 0	||
			   recordInfo.codLanguage 	== null	||
			   recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
