package br.com.gda.business.ownerStore.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OwntoreCopyOwner extends InfoCopierTemplate<OwntoreInfo, OwnerInfo>{
	
	public OwntoreCopyOwner() {
		super();
	}
	
	
	
	@Override protected OwntoreInfo makeCopyHook(OwnerInfo source) {
		OwntoreInfo result = new OwntoreInfo();
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
