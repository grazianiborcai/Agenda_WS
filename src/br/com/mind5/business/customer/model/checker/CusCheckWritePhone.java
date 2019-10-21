package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusCheckWritePhone extends ModelCheckerTemplateSimple_<CusInfo> {

	public CusCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)
			return super.SUCCESS;
		
		
		if (recordInfo.phones.isEmpty())
			return super.SUCCESS;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			if (checkPhone(eachPhone) == super.FAILED)
				return super.FAILED;
		}
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkPhone(PhoneInfo phone) {
		if (phone.codPhone <= 0)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_COD_IS_FILLED;
	}
}
