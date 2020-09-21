package br.com.mind5.business.storeTextSearch.info;


import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorextarchCopyStorext extends InfoCopierTemplate<StorextarchInfo, StorextInfo> {
	
	public StorextarchCopyStorext() {
		super();
	}
	
	
	
	@Override protected StorextarchInfo makeCopyHook(StorextInfo source) {
		StorextarchInfo result = new StorextarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = null;
		
		return result;
	}
}
