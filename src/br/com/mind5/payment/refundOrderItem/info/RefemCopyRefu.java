package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class RefemCopyRefu extends InfoCopierOneToManyTemplate<RefemInfo, RefuInfo>{
	
	public RefemCopyRefu() {
		super();
	}
	
	
	
	@Override protected List<RefemInfo> makeCopyHook(RefuInfo source) {
		List<RefemInfo> results = new ArrayList<>();
		
		for (OrdemarchInfo eachItem : source.ordemarches) {
			RefemInfo oneResult = RefemInfo.copyFrom(eachItem);
			results.add(oneResult);
		}
		
		return results;
	}
}
