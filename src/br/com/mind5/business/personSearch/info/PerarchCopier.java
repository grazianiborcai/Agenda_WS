package br.com.mind5.business.personSearch.info;


import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoCopier;

public final class PerarchCopier {
	public static List<PerarchInfo> copyFromCusarch(List<CusarchInfo> sources) {
		InfoCopier<PerarchInfo, CusarchInfo> copier = new PerarchCopyCusarch();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<PerarchInfo> copyFromEmplis(List<EmplisInfo> sources) {
		InfoCopier<PerarchInfo, EmplisInfo> copier = new PerarchCopyEmplis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<PerarchInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<PerarchInfo, EmpInfo> copier = new PerarchCopyEmp();
		return copier.makeCopy(sources);
	}
}
