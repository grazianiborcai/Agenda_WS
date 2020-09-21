package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;

public final class StorextCopier {
	public static List<StorextInfo> copyFromStore(StoreInfo source) {
		InfoCopierOneToMany<StorextInfo, StoreInfo> copier = new StorextCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopierOneToMany<StorextInfo, StoreInfo> copier = new StorextCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StorextInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<StorextInfo, StoreInfo> copier = new StorextCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<StorextInfo, StoreInfo> copier = new StorextCopyStoreKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StorextInfo copyFromMatextsnap(MatextsnapInfo source) {
		InfoCopier<StorextInfo, MatextsnapInfo> copier = new StorextCopyMatextsnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StorextInfo> copyFromMatextsnap(List<MatextsnapInfo> sources) {
		InfoCopier<StorextInfo, MatextsnapInfo> copier = new StorextCopyMatextsnap();
		return copier.makeCopy(sources);
	}
}
