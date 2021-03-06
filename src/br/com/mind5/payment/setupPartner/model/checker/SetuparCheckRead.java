package br.com.mind5.payment.setupPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SetuparCheckRead extends ModelCheckerTemplateSimple<SetuparInfo> {

	public SetuparCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SetuparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_SETUP_MANDATORY_FIELD_EMPTY;
	}
}
