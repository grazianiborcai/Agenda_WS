package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckSysparData extends ModelCheckerTemplateSimple<PaymoipInfo> {

	public PaymoipCheckSysparData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {		
		if ( recordInfo.sysparData == null )				
			return super.FAILED;		
		
		if ( recordInfo.sysparData.payPartnerName == null )				
			return super.FAILED;			
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
