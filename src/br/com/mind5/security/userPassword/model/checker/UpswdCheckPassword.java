package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;
import java.util.regex.Pattern;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckPassword extends ModelCheckerTemplateSimpleV2<UpswdInfo> {

	public UpswdCheckPassword(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.password == null)
			return super.FAILED;
		
		if (checkMinimunLength(recordInfo.password) == super.FAILED)
			return super.FAILED;
		
		if (checkMaximunLength(recordInfo.password) == super.FAILED)
			return super.FAILED;
		
		if (hasNumber(recordInfo.password) == super.FAILED)
			return super.FAILED;
		
		if (hasUpperCase(recordInfo.password) == super.FAILED)
			return super.FAILED;
		
		if (hasLowerCase(recordInfo.password) == super.FAILED)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkMinimunLength(String password) {
		int len = password.length();
		
		if (len < 8)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkMaximunLength(String password) {
		int len = password.length();
		
		if (len > 15)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean hasNumber(String password) {
		String regex = "[0-9]+";      
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(password).find();
	}
	
	
	
	private boolean hasUpperCase(String password) {
		String regex = "[A-Z]+";      
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(password).find();
	}
	
	
	
	private boolean hasLowerCase(String password) {
		String regex = "[a-z]+";      
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(password).find();
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_FAILED_RULE;
	}
}
