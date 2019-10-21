package br.com.mind5.payment.storePartnerList.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisCheckRead extends ModelCheckerTemplateSimpleV2<StoplisInfo> {

	public StoplisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoplisInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    	<= 0	||
			   recordInfo.codStore    	<= 0 	||
			   recordInfo.codLanguage 	== null	||
			   recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_MANDATORY_FIELD_EMPTY;
	}
}
