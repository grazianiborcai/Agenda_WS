package br.com.gda.business.user.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserCheckWritePhone extends ModelCheckerTemplateSimple<UserInfo> {

	public UserCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)
			return SUCCESS;
		
		
		if (recordInfo.phones.isEmpty())
			return SUCCESS;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			if (checkPhone(eachPhone) == FAILED)
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkPhone(PhoneInfo phone) {
		if (phone.codPhone <= 0)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_COD_IS_FILLED;
	}
}
