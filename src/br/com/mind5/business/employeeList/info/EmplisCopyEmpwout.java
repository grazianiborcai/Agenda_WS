package br.com.mind5.business.employeeList.info;


import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplisCopyEmpwout extends InfoCopierTemplate<EmplisInfo, EmpwoutInfo>{
	
	public EmplisCopyEmpwout() {
		super();
	}
	
	
	
	@Override protected EmplisInfo makeCopyHook(EmpwoutInfo source) {
		EmplisInfo result = new EmplisInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
