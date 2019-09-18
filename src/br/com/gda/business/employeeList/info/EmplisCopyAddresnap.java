package br.com.gda.business.employeeList.info;


import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class EmplisCopyAddresnap extends InfoCopierTemplate<EmplisInfo, AddresnapInfo>{
	
	public EmplisCopyAddresnap() {
		super();
	}
	
	
	
	@Override protected EmplisInfo makeCopyHook(AddresnapInfo source) {
		EmplisInfo result = new EmplisInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
