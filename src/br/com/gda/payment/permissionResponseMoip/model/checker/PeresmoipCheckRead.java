package br.com.gda.payment.permissionResponseMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;

public final class PeresmoipCheckRead extends ModelCheckerTemplateSimple<PeresmoipInfo> {

	public PeresmoipCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0		||
			   recordInfo.codStore    <= 0 		||
			   recordInfo.codLanguage == null		)			
			
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
