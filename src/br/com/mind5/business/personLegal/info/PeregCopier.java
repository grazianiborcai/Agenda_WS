package br.com.mind5.business.personLegal.info;


import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class PeregCopier {
	public static PeregInfo copyFromStore(StoreInfo source) {
		InfoCopier<PeregInfo, StoreInfo> copier = new PeregCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PeregInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<PeregInfo, StoreInfo> copier = new PeregCopyStore();
		return copier.makeCopy(sources);
	}
}
