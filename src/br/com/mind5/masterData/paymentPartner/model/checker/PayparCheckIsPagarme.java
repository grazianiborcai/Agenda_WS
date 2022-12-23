package br.com.mind5.masterData.paymentPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentPartner.info.Paypar;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PayparCheckIsPagarme extends ModelCheckerTemplateSimple<PayparInfo> {
	
	public PayparCheckIsPagarme(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner != Paypar.PAGARME.getCodPayPartner() )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_MANDATORY_FIELD_EMPTY;
	}
}
