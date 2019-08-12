package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoCopier;

public final class StoreCopier {
	public static StoreInfo copyFromOwntore(OwntoreInfo source) {
		InfoCopier<StoreInfo, OwntoreInfo> copier = new StoreCopyOwntore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoreInfo> copyFromOwntore(List<OwntoreInfo> sources) {
		InfoCopier<StoreInfo, OwntoreInfo> copier = new StoreCopyOwntore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StoreInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<StoreInfo, StoreInfo> copier = new StoreCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoreInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<StoreInfo, StoreInfo> copier = new StoreCopyStoreKey();
		return copier.makeCopy(sources);
	}
}
