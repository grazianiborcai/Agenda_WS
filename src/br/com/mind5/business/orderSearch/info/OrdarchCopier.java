package br.com.mind5.business.orderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class OrdarchCopier {	
	public static OrdarchInfo copyFromPayord(PayordInfo source) {
		InfoCopier<OrdarchInfo, PayordInfo> copier = new OrdarchCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdarchInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<OrdarchInfo, PayordInfo> copier = new OrdarchCopyPayord();
		return copier.makeCopy(sources);
	}	
}
