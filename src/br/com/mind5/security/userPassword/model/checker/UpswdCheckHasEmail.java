package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckHasEmail extends ModelCheckerTemplateSimpleV2<UpswdInfo> {

	public UpswdCheckHasEmail(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.persolisData == null )			
			return super.FAILED;
		
		
		if ( recordInfo.persolisData.email == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_EMAIL_IS_BLANK;
	}
}
