package br.com.mind5.business.materialStore.info;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatoreCopyStoreKey extends InfoCopierTemplate<MatoreInfo, StoreInfo>{
	
	public MatoreCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected MatoreInfo makeCopyHook(StoreInfo source) {
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
