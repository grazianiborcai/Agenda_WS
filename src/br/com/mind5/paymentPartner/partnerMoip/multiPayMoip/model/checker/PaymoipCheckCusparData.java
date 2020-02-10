package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCusparData extends ModelCheckerTemplateSimpleV2<PaymoipInfo> {

	public PaymoipCheckCusparData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.cusparData == null )	
			return super.FAILED;
		
		if ( recordInfo.cusparData.customerId 	 == null ||
			 recordInfo.cusparData.codPayPartner <= 0		)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
