package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyCus extends InfoCopierTemplate<FimistInfo, CusInfo>{
	
	public FimistCopyCus() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(CusInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
