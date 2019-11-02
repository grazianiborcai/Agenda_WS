package br.com.mind5.payment.partnerMoip.tokenMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckWrite extends ModelCheckerTemplateSimpleV2<TokemoipInfo> {

	public TokemoipCheckWrite(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TOKEN_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
