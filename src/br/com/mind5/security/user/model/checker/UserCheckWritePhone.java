package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckWritePhone extends ModelCheckerTemplateSimple_<UserInfo> {

	public UserCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)
			return super.SUCCESS;
		
		
		if (recordInfo.phones.isEmpty())
			return super.SUCCESS;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			if (checkPhone(eachPhone) == super.FAILED)
				return super.FAILED;
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
