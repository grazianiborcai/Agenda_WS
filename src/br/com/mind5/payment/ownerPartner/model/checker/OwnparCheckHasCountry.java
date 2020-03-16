package br.com.mind5.payment.ownerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckHasCountry extends ModelCheckerTemplateSimpleV2<OwnparInfo> {
	
	public OwnparCheckHasCountry(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnparInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codCountry == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_OWNER_COUNTRY_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_OWNER_COUNTRY_IS_NULL;
	}
}
