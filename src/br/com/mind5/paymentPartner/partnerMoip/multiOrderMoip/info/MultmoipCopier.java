package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class MultmoipCopier {	
	public static MultmoipInfo copyFromPayord(PayordInfo source) {
		InfoCopier<MultmoipInfo, PayordInfo> copier = new MultmoipCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MultmoipInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<MultmoipInfo, PayordInfo> copier = new MultmoipCopyPayord();
		return copier.makeCopy(sources);
	}
}
