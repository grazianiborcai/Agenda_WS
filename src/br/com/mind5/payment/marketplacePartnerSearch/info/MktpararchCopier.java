package br.com.mind5.payment.marketplacePartnerSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class MktpararchCopier {	
	public static MktpararchInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopier<MktpararchInfo, RefumoipInfo> copier = new MktpararchCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MktpararchInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopier<MktpararchInfo, RefumoipInfo> copier = new MktpararchCopyRefumoip();
		return copier.makeCopy(sources);
	}
}
