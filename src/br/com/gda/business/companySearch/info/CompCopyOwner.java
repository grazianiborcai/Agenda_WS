package br.com.gda.business.companySearch.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CompCopyOwner extends InfoCopierTemplate<CompInfo, OwnerInfo>{
	
	public CompCopyOwner() {
		super();
	}
	
	
	
	@Override protected CompInfo makeCopyHook(OwnerInfo source) {
		CompInfo result = CompInfo.copyFrom(source.companyData);
		result.username = source.username;
		return result;
	}
}
