package br.com.mind5.payment.partnerMoip.tokenMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckWrite extends ModelCheckerTemplateSimple_<TokemoipInfo> {

	public TokemoipCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TokemoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||	
			 recordInfo.codStore	<= 0 	||
			 recordInfo.code 		== null ||
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
