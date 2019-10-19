package br.com.gda.payment.storePartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class StoparCheckRead extends ModelCheckerTemplateSimpleV2<StoparInfo> {

	public StoparCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoparInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0		||
			   recordInfo.codStore    <= 0 		||
			   recordInfo.codLanguage == null	||
			   recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_MANDATORY_FIELD_EMPTY;
	}
}
