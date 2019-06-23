package br.com.gda.payment.customerPartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class CusparCopier {	
	public static CusparInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(sources);
	}	
}
