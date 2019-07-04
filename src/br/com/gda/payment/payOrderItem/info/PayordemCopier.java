package br.com.gda.payment.payOrderItem.info;


import java.util.List;

import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordemCopier {
	public static List<PayordemInfo> copyFromPayord(PayordInfo source) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayord();
		return copier.makeCopy(sources);
	}
}
