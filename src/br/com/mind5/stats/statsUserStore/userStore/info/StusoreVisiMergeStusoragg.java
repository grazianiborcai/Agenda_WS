package br.com.mind5.stats.statsUserStore.userStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

final class StusoreVisiMergeStusoragg extends InfoMergerVisitorTemplate<StusoreInfo, StusoraggInfo> {

	@Override public boolean shouldMerge(StusoreInfo baseInfo, StusoraggInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StusoreInfo> merge(StusoreInfo baseInfo, StusoraggInfo selectedInfo) {
		List<StusoreInfo> results = new ArrayList<>();
		
		StusoreInfo result = StusoreInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
