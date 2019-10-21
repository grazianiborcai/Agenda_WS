package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckWriteAddress extends ModelCheckerTemplateSimple_<UserInfo> {

	public UserCheckWriteAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null)
			return super.SUCCESS;
		
		
		if (recordInfo.addresses.isEmpty())
			return super.SUCCESS;
		
		
		for (AddressInfo eachAddress : recordInfo.addresses) {
			if (checkAddress(eachAddress) == super.FAILED)
				return super.FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkAddress(AddressInfo address) {
		if (address.codAddress <= 0)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ADDRESS_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ADDRESS_COD_IS_FILLED;
	}
}
