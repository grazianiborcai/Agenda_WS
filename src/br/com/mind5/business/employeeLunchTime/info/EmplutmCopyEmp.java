package br.com.mind5.business.employeeLunchTime.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplutmCopyEmp extends InfoCopierOneToManyTemplate<EmplutmInfo, EmpInfo> {
	
	public EmplutmCopyEmp() {
		super();
	}
	
	
	
	@Override protected List<EmplutmInfo> makeCopyHook(EmpInfo source) {
		return source.emplutmes;
	}
}
