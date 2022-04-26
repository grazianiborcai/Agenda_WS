package br.com.mind5.business.employeeLunchTime.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class EmplutmCopier {
	public static List<EmplutmInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopierOneToMany<EmplutmInfo, EmpInfo> copier = new EmplutmCopyEmp();
		return copier.makeCopy(sources);
	}	
}
