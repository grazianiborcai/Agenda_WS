package br.com.mind5.payment.storePartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckInsert extends ModelCheckerTemplateSimple<StoparInfo> {

	public StoparCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.idPayPartnerStore == null )			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_MANDATORY_FIELD_EMPTY;
	}
}
