package br.com.mind5.business.refundPolicyOwnerSearch.info;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class RefupowarchCopyRefupown extends InfoCopierTemplate<RefupowarchInfo, RefupownInfo> {
	
	public RefupowarchCopyRefupown() {
		super();
	}
	
	
	
	@Override protected RefupowarchInfo makeCopyHook(RefupownInfo source) {
		RefupowarchInfo result = new RefupowarchInfo();
		
		result.codOwner = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
