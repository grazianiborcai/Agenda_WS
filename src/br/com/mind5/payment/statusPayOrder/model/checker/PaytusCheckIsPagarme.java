package br.com.mind5.payment.statusPayOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.paymentPartner.info.Paypar;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckIsPagarme extends ModelCheckerTemplateSimple<PaytusInfo> {

	public PaytusCheckIsPagarme(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaytusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner == Paypar.PAGARME.getCodPayPartner() )
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_NOT_FOUND_M);
		builder.addParam01(SystemCode.PAY_STATUS_HEADER);
		builder.addParam02(SystemCode.PAY_PARTNER);

		return builder.build();
	}
}
