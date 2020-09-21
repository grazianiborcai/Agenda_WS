package br.com.mind5.business.storeTextSearch.info;


import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorextarchCopyMatextsnap extends InfoCopierTemplate<StorextarchInfo, MatextsnapInfo> {
	
	public StorextarchCopyMatextsnap() {
		super();
	}
	
	
	
	@Override protected StorextarchInfo makeCopyHook(MatextsnapInfo source) {
		StorextarchInfo result = new StorextarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codMat;
		result.username = source.username;
		result.codLanguage = null;
		
		return result;
	}
}
