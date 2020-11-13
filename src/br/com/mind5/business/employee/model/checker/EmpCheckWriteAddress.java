package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpCheckWriteAddress extends ModelCheckerTemplateSimple<EmpInfo> {

	public EmpCheckWriteAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null)
			return super.SUCCESS;
		
		
		if (recordInfo.addresses.isEmpty())
			return super.SUCCESS;
		
		
		for (AddressInfo eachAddress : recordInfo.addresses) {
			if (checkAddress(eachAddress) == super.FAILED)
				return super.FAILED;
		}
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkAddress(AddressInfo address) {
		if (address.codAddress <= 0)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_ADDRESS_NUMBER_IS_NULL;
	}
}
