package br.com.gda.payment.partnerMoip.accessMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckWrite extends ModelCheckerTemplateSimpleV2<AccemoipInfo> {

	public AccemoipCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AccemoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||	
			 recordInfo.codStore	<= 0 	||
			 recordInfo.codLanguage == null ||
			 recordInfo.username 	== null 	)
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ACCESS_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
