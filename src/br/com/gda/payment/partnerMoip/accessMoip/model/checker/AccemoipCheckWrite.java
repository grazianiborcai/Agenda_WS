package br.com.gda.payment.partnerMoip.accessMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckWrite extends ModelCheckerTemplateSimple_<AccemoipInfo> {

	public AccemoipCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AccemoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||	
			 recordInfo.codStore	<= 0 	||
			 recordInfo.codLanguage == null ||
			 recordInfo.username 	== null 	)
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ACCESS_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ACCESS_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
