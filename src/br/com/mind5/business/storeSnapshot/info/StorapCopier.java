package br.com.mind5.business.storeSnapshot.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

public final class StorapCopier {
	public static StorapInfo copyFromStore(StoreInfo source) {
		InfoCopier<StorapInfo, StoreInfo> copier = new StorapCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorapInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<StorapInfo, StoreInfo> copier = new StorapCopyStore();
		return copier.makeCopy(sources);
	}
}
