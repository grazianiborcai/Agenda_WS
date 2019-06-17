package br.com.gda.payment.ownerPartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckRead extends ModelCheckerTemplateSimple<OwnparInfo> {

	public OwnparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OwnparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
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
