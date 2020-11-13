package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentPartner.info.Paypar;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckIsMoip extends ModelCheckerTemplateSimple<CusparInfo> {

	public CusparCheckIsMoip(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner == Paypar.MOIP.getCodPayPartner() )
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_PAY_PARTNER_NOT_FOUND;
	}
}
