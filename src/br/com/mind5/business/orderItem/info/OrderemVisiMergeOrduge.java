package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeOrduge implements InfoMergerVisitorV3<OrderemInfo, OrdugeInfo> {

	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, OrdugeInfo selectedInfo) {
		if (baseInfo.codOrderStatus == null)
			return true;
		
		return baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatusOld);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, OrdugeInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codOrderStatus = selectedInfo.codOrderStatusNew;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
