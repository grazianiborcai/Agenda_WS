package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;

final class OrdistVisiMergeOrderatus extends InfoMergerVisitorTemplate<OrdistInfo, OrderatusInfo> {

	@Override public List<OrdistInfo> beforeMerge(List<OrdistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistInfo baseInfo, OrderatusInfo selectedInfo) {
		return (baseInfo.codOrderStatus.equals(selectedInfo.codOrderStatus));
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, OrderatusInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		baseInfo.txtOrderStatus = selectedInfo.txtOrderStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistInfo> getUniquifier() {
		return null;
	}
}
