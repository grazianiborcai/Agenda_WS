package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class RefemMergerVisiPayordem extends InfoMergerVisitorTemplate<RefemInfo, PayordemInfo> {

	@Override public boolean shouldMerge(RefemInfo baseInfo, PayordemInfo selectedInfo) {
		return ( baseInfo.codOwner 		  == baseInfo.codOwner 	  &&
				 baseInfo.codPayOrder 	  == baseInfo.codPayOrder &&
				 baseInfo.codPayOrderItem == baseInfo.codPayOrderItem );
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, PayordemInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.codOrder = selectedInfo.codOrder;
		baseInfo.codOrderItem = selectedInfo.codOrderItem;
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.idOrderPartner = selectedInfo.idOrderPartner;
		baseInfo.idRefundPartner = selectedInfo.idRefundPartner;
		baseInfo.statusRefundPartner = selectedInfo.statusRefundPartner;	
		baseInfo.itemReceiver = selectedInfo.itemReceiver;
		
		results.add(baseInfo);
		return results;
	}
}
