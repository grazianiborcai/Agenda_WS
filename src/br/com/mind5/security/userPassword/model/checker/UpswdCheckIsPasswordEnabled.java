package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.common.UserCategory;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckIsPasswordEnabled extends ModelCheckerTemplateSimpleV2<UpswdInfo> {

	public UpswdCheckIsPasswordEnabled(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		UserCategory categ = getUserCateg(recordInfo);
		
		if (categ.isPasswordEnabled() == true)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private UserCategory getUserCateg(UpswdInfo recordInfo) {
		return UserCategory.getUserCateg(recordInfo.codUserCategory);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_IS_NOT_PWD_ENABLED;
	}
}
