package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckCusparData extends ModelCheckerTemplateSimple_<MultmoipInfo> {

	public MultmoipCheckCusparData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.cusparData == null )	
			return super.FAILED;
		
		if ( recordInfo.cusparData.customerId 	 == null ||
			 recordInfo.cusparData.codPayPartner <= 0		)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MULT_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
