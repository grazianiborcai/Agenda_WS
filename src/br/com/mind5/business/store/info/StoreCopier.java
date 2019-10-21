package br.com.mind5.business.store.info;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopier;

public final class StoreCopier {	
	public static StoreInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<StoreInfo, OwnerInfo> copier = new StoreCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoreInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<StoreInfo, OwnerInfo> copier = new StoreCopyOwner();
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
