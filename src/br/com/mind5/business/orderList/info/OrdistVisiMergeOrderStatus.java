package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrdistVisiMergeOrderStatus implements InfoMergerVisitorV3<OrdistInfo, OrderStatusInfo> {

	@Override public List<OrdistInfo> beforeMerge(List<OrdistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistInfo baseInfo, OrderStatusInfo selectedInfo) {
		return (baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatus));
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, OrderStatusInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		baseInfo.txtOrderStatus = selectedInfo.txtOrderStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistInfo> getUniquifier() {
		return null;
	}
}
