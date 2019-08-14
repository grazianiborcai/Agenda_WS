package br.com.gda.business.companySnapshot.info;


import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopier;

public final class CompnapCopier {	
	public static CompnapInfo copyFromStorap(StorapInfo source) {
		InfoCopier<CompnapInfo, StorapInfo> copier = new CompnapCopyStorap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CompnapInfo> copyFromStorap(List<StorapInfo> sources) {
		InfoCopier<CompnapInfo, StorapInfo> copier = new CompnapCopyStorap();
		return copier.makeCopy(sources);
	}
}
