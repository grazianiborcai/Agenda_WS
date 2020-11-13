package br.com.mind5.payment.ownerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckRead extends ModelCheckerTemplateSimple<OwnparInfo> {

	public OwnparCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnparInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_OWNER_MANDATORY_FIELD_EMPTY;
	}
}
