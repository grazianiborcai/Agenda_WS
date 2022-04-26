package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class EmpwotmCopier {
	public static List<EmpwotmInfo> copyFromStore(List<EmpInfo> sources) {
		InfoCopierOneToMany<EmpwotmInfo, EmpInfo> copier = new EmpwotmCopyEmp();
		return copier.makeCopy(sources);
	}	
}
