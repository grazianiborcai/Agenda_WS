package br.com.mind5.business.employeeList.info;


import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplisCopyAddresnap extends InfoCopierTemplate<EmplisInfo, AddresnapInfo> {
	
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
