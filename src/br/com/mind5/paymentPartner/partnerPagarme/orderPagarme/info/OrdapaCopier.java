package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;


import java.util.List;

import br.com.mind5.info.InfoCopierOneToMany;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class OrdapaCopier {	
	
	public static List<OrdapaInfo> copyFromPayord(PayordInfo source) {
		InfoCopierOneToMany<OrdapaInfo, PayordInfo> copier = new OrdapaCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdapaInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopierOneToMany<OrdapaInfo, PayordInfo> copier = new OrdapaCopyPayord();
		return copier.makeCopy(sources);
	}
}
