package br.com.mind5.payment.creditCardSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class CrecarchCopier {	
	public static CrecarchInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CrecarchInfo, PayordInfo> copier = new CrecarchCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CrecarchInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CrecarchInfo, PayordInfo> copier = new CrecarchCopyPayord();
		return copier.makeCopy(sources);
	}		
}
