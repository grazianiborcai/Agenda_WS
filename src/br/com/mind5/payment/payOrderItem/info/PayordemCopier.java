package br.com.mind5.payment.payOrderItem.info;


import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class PayordemCopier {
	public static PayordemInfo copyFromPaytusem(PaytusemInfo source) {
		InfoCopierTemplate<PayordemInfo, PaytusemInfo> copier = new PayordemCopyPaytusem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPaytusem(List<PaytusemInfo> sources) {
		InfoCopierTemplate<PayordemInfo, PaytusemInfo> copier = new PayordemCopyPaytusem();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PayordemInfo copyFromPayordKey(PayordInfo source) {
		InfoCopierTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayordKey(List<PayordInfo> sources) {
		InfoCopierTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayord(PayordInfo source) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayord();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PayordemInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopierTemplate<PayordemInfo, OrdmoipInfo> copier = new PayordemCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopierTemplate<PayordemInfo, OrdmoipInfo> copier = new PayordemCopyOrdmoip();
		return copier.makeCopy(sources);
	}
}
