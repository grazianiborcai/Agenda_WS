package br.com.mind5.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckCusparData extends ModelCheckerTemplateSimpleV2<RefumoipInfo> {

	public RefumoipCheckCusparData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.cusparData == null )	
			return super.FAILED;
		
		if ( recordInfo.cusparData.customerId 	 == null ||
			 recordInfo.cusparData.codPayPartner <= 0		)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
