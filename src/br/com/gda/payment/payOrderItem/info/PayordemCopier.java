package br.com.gda.payment.payOrderItem.info;


import java.util.List;

import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordemCopier {
	public static PayordemInfo copyFromPayordToRead(PayordInfo source) {
		InfoCopierTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordToRead();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayordToRead(List<PayordInfo> sources) {
		InfoCopierTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordToRead();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayordToWrite(PayordInfo source) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordToWrite();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PayordemInfo> copyFromPayordToWrite(List<PayordInfo> sources) {
		InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo> copier = new PayordemCopyPayordToWrite();
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
