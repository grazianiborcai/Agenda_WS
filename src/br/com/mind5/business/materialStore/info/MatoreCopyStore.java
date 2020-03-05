package br.com.mind5.business.materialStore.info;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatoreCopyStore extends InfoCopierTemplate<MatoreInfo, StoreInfo>{
	
	public MatoreCopyStore() {
		super();
	}
	
	
	
	@Override protected MatoreInfo makeCopyHook(StoreInfo source) {
		MatoreInfo result = new MatoreInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
