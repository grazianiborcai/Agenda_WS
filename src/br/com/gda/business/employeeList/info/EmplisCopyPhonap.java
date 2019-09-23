package br.com.gda.business.employeeList.info;


import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class EmplisCopyPhonap extends InfoCopierTemplate<EmplisInfo, PhonapInfo>{
	
	public EmplisCopyPhonap() {
		super();
	}
	
	
	
	@Override protected EmplisInfo makeCopyHook(PhonapInfo source) {
		EmplisInfo result = new EmplisInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
