package br.com.mind5.business.companySnapshot.info;


import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopier;

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
