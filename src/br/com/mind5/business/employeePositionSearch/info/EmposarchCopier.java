package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.info.InfoCopier;

public final class EmposarchCopier {	
	public static EmposarchInfo copyFromEmp(EmpInfo source) {
		InfoCopier<EmposarchInfo, EmpInfo> copier = new EmposarchCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmposarchInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<EmposarchInfo, EmpInfo> copier = new EmposarchCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
	public static EmposarchInfo copyFromEmpos(EmposInfo source) {
		InfoCopier<EmposarchInfo, EmposInfo> copier = new EmposarchCopyEmpos();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmposarchInfo> copyFromEmpos(List<EmposInfo> sources) {
		InfoCopier<EmposarchInfo, EmposInfo> copier = new EmposarchCopyEmpos();
		return copier.makeCopy(sources);
	}
}
