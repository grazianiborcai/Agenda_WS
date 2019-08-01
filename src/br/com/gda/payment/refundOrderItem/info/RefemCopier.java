package br.com.gda.payment.refundOrderItem.info;


import java.util.List;

import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.refundOrder.info.RefuInfo;

public final class RefemCopier {
	public static List<RefemInfo> copyFromRefu(RefuInfo source) {
		InfoCopierOneToManyTemplate<RefemInfo, RefuInfo> copier = new RefemCopyRefu();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<RefemInfo> copyFromRefu(List<RefuInfo> sources) {
		InfoCopierOneToManyTemplate<RefemInfo, RefuInfo> copier = new RefemCopyRefu();
		return copier.makeCopy(sources);
	}
}
