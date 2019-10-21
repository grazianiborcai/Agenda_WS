package br.com.mind5.payment.storePartnerSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapCheckRead extends ModelCheckerTemplateSimple_<StoparnapInfo> {

	public StoparnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StoparnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0		||
			   recordInfo.codSnapshot <= 0 		||
			   recordInfo.codLanguage == null	||
			   recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
