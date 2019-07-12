package br.com.gda.payment.tokenMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckWrite extends ModelCheckerTemplateSimple<TokemoipInfo> {

	public TokemoipCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TokemoipInfo recordInfo, Connection conn, String schemaName) {	
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
