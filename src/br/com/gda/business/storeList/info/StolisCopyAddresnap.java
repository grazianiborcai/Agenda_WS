package br.com.gda.business.storeList.info;


import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoCopierTemplate;

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
