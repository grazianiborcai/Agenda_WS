package br.com.mind5.business.personList.info;


import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoCopier;

public final class PersolisCopier {
	public static PersolisInfo copyFromEmpnap(EmpnapInfo source) {
		InfoCopier<PersolisInfo, EmpnapInfo> copier = new PersolisCopyEmpnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersolisInfo> copyFromEmpnap(List<EmpnapInfo> sources) {
		InfoCopier<PersolisInfo, EmpnapInfo> copier = new PersolisCopyEmpnap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersolisInfo copyFromOwnerap(OwnerapInfo source) {
		InfoCopier<PersolisInfo, OwnerapInfo> copier = new PersolisCopyOwnerap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersolisInfo> copyFromOwnerap(List<OwnerapInfo> sources) {
		InfoCopier<PersolisInfo, OwnerapInfo> copier = new PersolisCopyOwnerap();
		return copier.makeCopy(sources);
	}
}
