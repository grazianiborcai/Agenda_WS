package br.com.mind5.business.materialStore.info;


import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class MatoreCopier {
	public static MatoreInfo copyFromStore(StoreInfo source) {
		InfoCopier<MatoreInfo, StoreInfo> copier = new MatoreCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatoreInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<MatoreInfo, StoreInfo> copier = new MatoreCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static MatoreInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<MatoreInfo, StoreInfo> copier = new MatoreCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatoreInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<MatoreInfo, StoreInfo> copier = new MatoreCopyStoreKey();
		return copier.makeCopy(sources);
	}
}
