package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.UserCateg;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckIsPasswordEnabled extends ModelCheckerTemplateSimple_<UpswdInfo> {

	public UpswdCheckIsPasswordEnabled() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		UserCateg categ = getUserCateg(recordInfo);
		
		if (categ.isPasswordEnabled() == true)
			return SUCCESS;
		
		
		return FAILED;
	}
	
	
	
	private UserCateg getUserCateg(UpswdInfo recordInfo) {
		return UserCateg.getUserCateg(recordInfo.codUserCategory);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_PASSWORD_IS_NOT_PWD_ENABLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_PASSWORD_IS_NOT_PWD_ENABLED;
	}
}
