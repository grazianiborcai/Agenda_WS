package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeOrdemist implements InfoMergerVisitorV3<SchedineInfo, OrdemistInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner 	  == selectedInfo.codOwner &&
				baseInfo.codOrder 	  == selectedInfo.codOrder &&
				baseInfo.codOrderItem == selectedInfo.codOrderItem);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, OrdemistInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codOrderStatus = selectedInfo.codOrderStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
