package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmulonVisiMergeStolis extends InfoMergerVisitorTemplate<EmulonInfo, StolisInfo> {
	
	@Override public List<EmulonInfo> beforeMerge(List<EmulonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulonInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner ||
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<EmulonInfo> merge(EmulonInfo baseInfo, StolisInfo selectedInfo) {
		List<EmulonInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulonInfo> getUniquifier() {
		return null;
	}
}
