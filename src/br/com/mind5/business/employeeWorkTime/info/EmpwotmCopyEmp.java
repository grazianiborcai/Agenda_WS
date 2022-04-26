package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmpwotmCopyEmp extends InfoCopierOneToManyTemplate<EmpwotmInfo, EmpInfo> {
	
	public EmpwotmCopyEmp() {
		super();
	}
	
	
	
	@Override protected List<EmpwotmInfo> makeCopyHook(EmpInfo source) {
		return source.empwotmes;
	}
}
