package br.com.mind5.payment.storePartnerSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapCheckRead extends ModelCheckerTemplateSimpleV2<StoparnapInfo> {

	public StoparnapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoparnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0		||
			   recordInfo.codSnapshot <= 0 		||
			   recordInfo.codLanguage == null	||
			   recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_STORE_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
