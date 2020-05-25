package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplisCopyScheday extends InfoCopierTemplate<EmplisInfo, SchedayInfo> {
	
	public EmplisCopyScheday() {
		super();
	}
	
	
	
	@Override protected EmplisInfo makeCopyHook(SchedayInfo source) {
		EmplisInfo result = new EmplisInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
