package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorygeVisiMergeOrdist extends InfoMergerVisitorTemplate<StusorygeInfo, OrdistInfo> {

	@Override public boolean shouldMerge(StusorygeInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorygeInfo> merge(StusorygeInfo baseInfo, OrdistInfo selectedInfo) {
		List<StusorygeInfo> results = new ArrayList<>();
		
		StusorygeInfo result = StusorygeInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
