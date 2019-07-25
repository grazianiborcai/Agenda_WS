package br.com.gda.payment.customerPartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;

public final class CusparCopier {	
	public static CusparInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<CusparInfo, CrecardInfo> copier = new CusparCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<CusparInfo, CrecardInfo> copier = new CusparCopyCrecard();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static CusparInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(sources);
	}		
	
	
	
	public static CusparInfo copyFromPaytus(PaytusInfo source) {
		InfoCopier<CusparInfo, PaytusInfo> copier = new CusparCopyPaytus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromPaytus(List<PaytusInfo> sources) {
		InfoCopier<CusparInfo, PaytusInfo> copier = new CusparCopyPaytus();
		return copier.makeCopy(sources);
	}		
}
