package br.com.mind5.stats.statsUserStore.userStoreStgn.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorageVisiMergeOrdemist extends InfoMergerVisitorTemplate<StusorageInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(StusorageInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorageInfo> merge(StusorageInfo baseInfo, OrdemistInfo selectedInfo) {
		List<StusorageInfo> results = new ArrayList<>();
		
		StusorageInfo result = StusorageInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
