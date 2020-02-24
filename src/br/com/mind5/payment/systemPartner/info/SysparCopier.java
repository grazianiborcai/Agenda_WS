package br.com.mind5.payment.systemPartner.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class SysparCopier {	
	public static SysparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<SysparInfo, OrdmoipInfo> copier = new SysparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SysparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<SysparInfo, OrdmoipInfo> copier = new SysparCopyOrdmoip();
		return copier.makeCopy(sources);
	}
}
