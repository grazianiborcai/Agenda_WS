package br.com.mind5.business.personSnapshot.info;


import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class PersonapCopier {		
	public static PersonapInfo copyFromEmpnapKey(EmpnapInfo source) {
		InfoCopier<PersonapInfo, EmpnapInfo> copier = new PersonapCopyEmpnapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonapInfo> copyFromEmpnapKey(List<EmpnapInfo> sources) {
		InfoCopier<PersonapInfo, EmpnapInfo> copier = new PersonapCopyEmpnapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonapInfo copyFromUserapKey(UserapInfo source) {
		InfoCopier<PersonapInfo, UserapInfo> copier = new PersonapCopyUserapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonapInfo> copyFromUserapKey(List<UserapInfo> sources) {
		InfoCopier<PersonapInfo, UserapInfo> copier = new PersonapCopyUserapKey();
		return copier.makeCopy(sources);
	}	
}
