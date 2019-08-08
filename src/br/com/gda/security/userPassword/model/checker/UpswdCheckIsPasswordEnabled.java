package br.com.gda.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.UserCateg;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdCheckIsPasswordEnabled extends ModelCheckerTemplateSimple<UpswdInfo> {

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
