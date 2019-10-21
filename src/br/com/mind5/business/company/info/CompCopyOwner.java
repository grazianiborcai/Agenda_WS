package br.com.mind5.business.company.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
