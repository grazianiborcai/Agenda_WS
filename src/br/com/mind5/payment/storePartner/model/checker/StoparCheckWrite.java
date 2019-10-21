package br.com.mind5.payment.storePartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckWrite extends ModelCheckerTemplateSimpleV2<StoparInfo> {

	public StoparCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoparInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    	<= 0	||
			   recordInfo.codStore    	<= 0 	||
			   recordInfo.codPayPartner <= 0 	||
			   recordInfo.codLanguage 	== null	||
			   recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_MANDATORY_FIELD_EMPTY;
	}
}
