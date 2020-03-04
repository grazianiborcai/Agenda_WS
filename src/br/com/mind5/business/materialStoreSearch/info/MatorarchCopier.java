package br.com.mind5.business.materialStoreSearch.info;


import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class MatorarchCopier {	
	public static MatorarchInfo copyFromStore(StoreInfo source) {
		InfoCopier<MatorarchInfo, StoreInfo> copier = new MatorarchCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatorarchInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<MatorarchInfo, StoreInfo> copier = new MatorarchCopyStore();
		return copier.makeCopy(sources);
	}
}
