package br.com.mind5.payment.systemPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class SysparCheckRead extends ModelCheckerTemplateSimple_<SysparInfo> {

	public SysparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SysparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SYS_PAY_PARTNER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SYS_PAY_PARTNER_MANDATORY_FIELD_EMPTY;
	}
}
