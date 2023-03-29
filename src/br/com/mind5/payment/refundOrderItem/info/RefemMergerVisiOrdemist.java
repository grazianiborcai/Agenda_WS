package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefemMergerVisiOrdemist extends InfoMergerVisitorTemplate<RefemInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(RefemInfo baseInfo, OrdemistInfo selectedInfo) {
		return ( baseInfo.codOwner 	   == baseInfo.codOwner &&
				 baseInfo.codOrder 	   == baseInfo.codOrder &&
				 baseInfo.codOrderItem == baseInfo.codOrderItem );
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, OrdemistInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.codPayOrder     = selectedInfo.codPayOrder;
		baseInfo.codPayOrderItem = selectedInfo.codPayOrderItem;
		
		results.add(baseInfo);
		return results;
	}
}
