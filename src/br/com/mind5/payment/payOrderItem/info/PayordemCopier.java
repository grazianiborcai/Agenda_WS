package br.com.mind5.payment.payOrderItem.info;


import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PayordemCopier {
	public static PayordemInfo copyFromPaytusem(PaytusemInfo source) {
		InfoCopierTemplate<PayordemInfo, PaytusemInfo> copier = new PayordemCopyPaytusem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPaytusem(List<PaytusemInfo> sources) {
		InfoCopierTemplate<PayordemInfo, PaytusemInfo> copier = new PayordemCopyPaytusem();
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
}
