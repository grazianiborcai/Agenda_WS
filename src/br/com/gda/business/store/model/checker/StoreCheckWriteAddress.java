package br.com.gda.business.store.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoreCheckWriteAddress extends ModelCheckerTemplateSimpleV2<StoreInfo> {

	public StoreCheckWriteAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
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
		return SystemCode.STORE_ADDRESS_IS_EMPTY;
	}
}
