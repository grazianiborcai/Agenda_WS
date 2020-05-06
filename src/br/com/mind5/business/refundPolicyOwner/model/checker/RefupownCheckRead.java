package br.com.mind5.business.refundPolicyOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class RefupownCheckRead extends ModelCheckerTemplateSimpleV2<RefupownInfo> {

	public RefupownCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefupownInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codRefundPolicy <= 0 	||
			 recordInfo.codLanguage 	== null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_POL_OWNER_MANDATORY_FIELD_EMPTY;
	}
}
