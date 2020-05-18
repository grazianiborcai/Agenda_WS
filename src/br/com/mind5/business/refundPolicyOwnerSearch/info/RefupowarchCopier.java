package br.com.mind5.business.refundPolicyOwnerSearch.info;


import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoCopier;

public final class RefupowarchCopier {
	public static RefupowarchInfo copyFromCrecard(RefupownInfo source) {
		InfoCopier<RefupowarchInfo, RefupownInfo> copier = new RefupowarchCopyRefupown();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<RefupowarchInfo> copyFromCrecard(List<RefupownInfo> sources) {
		InfoCopier<RefupowarchInfo, RefupownInfo> copier = new RefupowarchCopyRefupown();
		return copier.makeCopy(sources);
	}
}
