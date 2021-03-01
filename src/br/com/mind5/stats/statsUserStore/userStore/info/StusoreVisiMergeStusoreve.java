package br.com.mind5.stats.statsUserStore.userStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

final class StusoreVisiMergeStusoreve extends InfoMergerVisitorTemplate<StusoreInfo, StusoreveInfo> {

	@Override public boolean shouldMerge(StusoreInfo baseInfo, StusoreveInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StusoreInfo> merge(StusoreInfo baseInfo, StusoreveInfo selectedInfo) {
		List<StusoreInfo> results = new ArrayList<>();
		
		StusoreInfo result = StusoreInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
