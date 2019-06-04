package br.com.gda.business.personSnapshot.info;


import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopier;

public final class PersonapCopier {		
	public static PersonapInfo copyFromEmpnapKey(EmpnapInfo source) {
		InfoCopier<PersonapInfo, EmpnapInfo> copier = new PersonapCopyEmpnapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonapInfo> copyFromEmpnapKey(List<EmpnapInfo> sources) {
		InfoCopier<PersonapInfo, EmpnapInfo> copier = new PersonapCopyEmpnapKey();
		return copier.makeCopy(sources);
	}
}
