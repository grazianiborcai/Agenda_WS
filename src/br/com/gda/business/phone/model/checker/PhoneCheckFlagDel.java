package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PhoneCheckFlagDel extends ModelCheckerTemplateSimple_<PhoneInfo> {

	public PhoneCheckFlagDel(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isDeleted )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PHONE_FLAG_DELETE_TRUE )
			return SystemMessage.PHONE_FLAG_DELETE_TRUE;
		
		return SystemMessage.PHONE_FLAG_DELETE_FALSE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ADDRESS_FLAG_DELETE_TRUE;	
			
		return SystemCode.ADDRESS_FLAG_DELETE_FALSE;
	}
}
