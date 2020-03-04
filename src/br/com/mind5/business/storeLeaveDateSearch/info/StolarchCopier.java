package br.com.mind5.business.storeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class StolarchCopier {	
	public static StolarchInfo copyFromStore(StoreInfo source) {
		InfoCopier<StolarchInfo, StoreInfo> copier = new StolarchCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolarchInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<StolarchInfo, StoreInfo> copier = new StolarchCopyStore();
		return copier.makeCopy(sources);
	}
}
