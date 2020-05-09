package br.com.mind5.payment.payOrderItemSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class PayormarchCopier {	
	public static PayormarchInfo copyFromRefem(RefemInfo source) {
		InfoCopierTemplate<PayormarchInfo, RefemInfo> copier = new PayormarchCopyRefem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayormarchInfo> copyFromRefem(List<RefemInfo> sources) {
		InfoCopierTemplate<PayormarchInfo, RefemInfo> copier = new PayormarchCopyRefem();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PayormarchInfo copyFromRefu(RefuInfo source) {
		InfoCopierTemplate<PayormarchInfo, RefuInfo> copier = new PayormarchCopyRefu();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayormarchInfo> copyFromRefu(List<RefuInfo> sources) {
		InfoCopierTemplate<PayormarchInfo, RefuInfo> copier = new PayormarchCopyRefu();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PayormarchInfo copyFromMultmoip(MultmoipInfo source) {
		InfoCopierTemplate<PayormarchInfo, MultmoipInfo> copier = new PayormarchCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayormarchInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopierTemplate<PayormarchInfo, MultmoipInfo> copier = new PayormarchCopyMultmoip();
		return copier.makeCopy(sources);
	}
}
