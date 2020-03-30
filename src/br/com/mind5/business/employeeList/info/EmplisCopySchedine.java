package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplisCopySchedine extends InfoCopierTemplate<EmplisInfo, SchedineInfo>{
	
	public EmplisCopySchedine() {
		super();
	}
	
	
	
	@Override protected EmplisInfo makeCopyHook(SchedineInfo source) {
		EmplisInfo result = new EmplisInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
