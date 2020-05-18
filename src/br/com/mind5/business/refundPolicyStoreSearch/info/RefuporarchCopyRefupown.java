package br.com.mind5.business.refundPolicyStoreSearch.info;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class RefuporarchCopyRefupown extends InfoCopierTemplate<RefuporarchInfo, RefupownInfo> {
	
	public RefuporarchCopyRefupown() {
		super();
	}
	
	
	
	@Override protected RefuporarchInfo makeCopyHook(RefupownInfo source) {
		RefuporarchInfo result = new RefuporarchInfo();
		
		result.codOwner = source.codOwner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
