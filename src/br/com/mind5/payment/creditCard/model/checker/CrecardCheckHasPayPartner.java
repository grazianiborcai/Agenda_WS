package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckHasPayPartner extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckHasPayPartner(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
}
