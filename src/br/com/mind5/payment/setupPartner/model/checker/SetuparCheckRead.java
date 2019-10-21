package br.com.mind5.payment.setupPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SetuparCheckRead extends ModelCheckerTemplateSimple_<SetuparInfo> {

	public SetuparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SetuparInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codPayPartner <= 0	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_PARTNER_SETUP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_PARTNER_SETUP_MANDATORY_FIELD_EMPTY;
	}
}
