package br.com.gda.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.refundOrder.info.RefuInfo;

final class RefemCopyRefu extends InfoCopierOneToManyTemplate<RefemInfo, RefuInfo>{
	
	public RefemCopyRefu() {
		super();
	}
	
	
	
	@Override protected List<RefemInfo> makeCopyHook(RefuInfo source) {
		List<RefemInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachItem : source.payordData.payordems) {
			RefemInfo oneResult = RefemInfo.copyFrom(eachItem);
			results.add(oneResult);
		}
		
		return results;
	}
}
