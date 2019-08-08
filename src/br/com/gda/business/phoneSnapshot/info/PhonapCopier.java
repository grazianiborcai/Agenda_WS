package br.com.gda.business.phoneSnapshot.info;


import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class PhonapCopier {	
	public static List<PhonapInfo> copyFromEmpnap(EmpnapInfo source) {
		InfoCopierOneToMany<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromEmpnap(List<EmpnapInfo> sources) {
		InfoCopierOneToMany<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static PhonapInfo copyFromEmpnapKey(EmpnapInfo source) {
		InfoCopier<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromEmpnapKey(List<EmpnapInfo> sources) {
		InfoCopier<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromUserapKey(UserapInfo source) {
		InfoCopier<PhonapInfo, UserapInfo> copier = new PhonapCopyUserapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromUserapKey(List<UserapInfo> sources) {
		InfoCopier<PhonapInfo, UserapInfo> copier = new PhonapCopyUserapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<PhonapInfo, CusparInfo> copier = new PhonapCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<PhonapInfo, CusparInfo> copier = new PhonapCopyCuspar();
		return copier.makeCopy(sources);
	}
}
