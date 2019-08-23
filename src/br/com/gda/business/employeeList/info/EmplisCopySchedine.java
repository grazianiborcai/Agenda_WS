package br.com.gda.business.employeeList.info;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.info.InfoCopierTemplate;

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
