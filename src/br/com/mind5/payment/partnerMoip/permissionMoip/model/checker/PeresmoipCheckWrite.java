package br.com.mind5.payment.partnerMoip.permissionMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckWrite extends ModelCheckerTemplateSimple_<PeresmoipInfo> {

	public PeresmoipCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    	<= 0	||
			   recordInfo.codStore    	<= 0 	||
			   recordInfo.username 		== null	||
			   recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MOIP_PERM_RESP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MOIP_PERM_RESP_MANDATORY_FIELD_EMPTY;
	}
}
