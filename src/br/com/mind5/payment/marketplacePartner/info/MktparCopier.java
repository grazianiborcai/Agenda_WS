package br.com.mind5.payment.marketplacePartner.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MktparCopier {	
	public static MktparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<MktparInfo, OrdmoipInfo> copier = new MktparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MktparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<MktparInfo, OrdmoipInfo> copier = new MktparCopyOrdmoip();
		return copier.makeCopy(sources);
	}
}
