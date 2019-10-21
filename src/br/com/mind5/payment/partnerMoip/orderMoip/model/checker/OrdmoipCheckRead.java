package br.com.mind5.payment.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckRead extends ModelCheckerTemplateSimple_<OrdmoipInfo> {

	public OrdmoipCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.idOrderPartner == null )	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
