package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyCuslis extends InfoCopierTemplate<FimistInfo, CuslisInfo> {
	
	public FimistCopyCuslis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(CuslisInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
