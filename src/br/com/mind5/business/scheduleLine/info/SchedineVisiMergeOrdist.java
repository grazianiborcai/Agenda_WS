package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeOrdist extends InfoMergerVisitorTemplate<SchedineInfo, OrdistInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner 	  == selectedInfo.codOwner &&
				baseInfo.codOrder 	  == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, OrdistInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
