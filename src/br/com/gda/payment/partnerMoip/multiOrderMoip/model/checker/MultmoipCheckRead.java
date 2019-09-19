package br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckRead extends ModelCheckerTemplateSimple_<MultmoipInfo> {

	public MultmoipCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MultmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.idOrderPartner == null )	
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
