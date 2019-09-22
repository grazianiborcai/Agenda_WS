package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhoneCheckDelete extends ModelCheckerTemplateSimpleV2<PhoneInfo> {

	public PhoneCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner   	<= 0 	||
			 recordInfo.codPhone	<= 0 	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_MANDATORY_FIELD_EMPTY;
	}
}
