package br.com.gda.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.Paypar;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparCheckIsMoip extends ModelCheckerTemplateSimple_<CusparInfo> {

	public CusparCheckIsMoip() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner == Paypar.MOIP.getCodPayPartner() )
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_PAY_PARTNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_PAY_PARTNER_NOT_FOUND;
	}
}
