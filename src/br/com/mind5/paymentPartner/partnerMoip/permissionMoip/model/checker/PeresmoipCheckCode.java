package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckCode extends ModelCheckerTemplateSimple<PeresmoipInfo> {

	public PeresmoipCheckCode(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    	<= 0	||
			   recordInfo.codStore    	<= 0 	||
			   recordInfo.codLanguage 	== null	||
			   recordInfo.username 		== null	||
			   recordInfo.code    		== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOIP_PERM_RESP_MANDATORY_FIELD_EMPTY;
	}
}
