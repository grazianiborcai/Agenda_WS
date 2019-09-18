package br.com.gda.business.address.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddressCopyEmpKey extends InfoCopierTemplate<AddressInfo, EmpInfo>{
	
	public AddressCopyEmpKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(EmpInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
