package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class RefemMergerVisiPayord extends InfoMergerVisitorTemplate<RefemInfo, PayordInfo> {

	@Override public boolean shouldMerge(RefemInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, PayordInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.codPayCustomer = selectedInfo.codPayCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
