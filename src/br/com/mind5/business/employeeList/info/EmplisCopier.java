package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoCopier;

public final class EmplisCopier {
	
	public static List<EmplisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<EmplisInfo, AddresnapInfo> copier = new EmplisCopyAddresnap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<EmplisInfo> copyFromPhonap(List<PhonapInfo> sources) {
		InfoCopier<EmplisInfo, PhonapInfo> copier = new EmplisCopyPhonap();
		return copier.makeCopy(sources);
	}	
}
