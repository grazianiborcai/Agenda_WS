package br.com.mind5.business.employeePositionSearch.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmposarchCopyEmp extends InfoCopierTemplate<EmposarchInfo, EmpInfo> {
	
	public EmposarchCopyEmp() {
		super();
	}
	
	
	
	@Override protected EmposarchInfo makeCopyHook(EmpInfo source) {
		EmposarchInfo result = new EmposarchInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.username = source.username;
		result.codLanguage = source.codLanguage;		
		
		return result;
	}
}
