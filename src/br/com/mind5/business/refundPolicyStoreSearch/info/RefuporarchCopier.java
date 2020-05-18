package br.com.mind5.business.refundPolicyStoreSearch.info;


import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoCopier;

public final class RefuporarchCopier {
	public static RefuporarchInfo copyFromRefupown(RefupownInfo source) {
		InfoCopier<RefuporarchInfo, RefupownInfo> copier = new RefuporarchCopyRefupown();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<RefuporarchInfo> copyFromRefupown(List<RefupownInfo> sources) {
		InfoCopier<RefuporarchInfo, RefupownInfo> copier = new RefuporarchCopyRefupown();
		return copier.makeCopy(sources);
	}
}
