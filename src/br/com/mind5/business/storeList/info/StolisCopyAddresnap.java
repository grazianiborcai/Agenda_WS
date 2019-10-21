package br.com.mind5.business.storeList.info;


import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolisCopyAddresnap extends InfoCopierTemplate<StolisInfo, AddresnapInfo>{
	
	public StolisCopyAddresnap() {
		super();
	}
	
	
	
	@Override protected StolisInfo makeCopyHook(AddresnapInfo source) {
		StolisInfo result = new StolisInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
