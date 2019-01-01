package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckWriteAddress extends ModelCheckerTemplateSimple<PayCusInfo> {

	public PayCusCheckWriteAddress() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null)
			return SUCCESS;
		
		
		if (recordInfo.addresses.isEmpty())
			return SUCCESS;
		
		
		for (AddressInfo eachAddress : recordInfo.addresses) {
			if (checkAddress(eachAddress) == FAILED)
				return FAILED;
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
