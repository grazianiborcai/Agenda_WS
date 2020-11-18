package br.com.mind5.business.storeProspect.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

final class StoprosVisiMergeProstus extends InfoMergerVisitorTemplate<StoprosInfo, ProstusInfo> {
	
	@Override public List<StoprosInfo> beforeMerge(List<StoprosInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoprosInfo baseInfo, ProstusInfo selectedInfo) {
		return (baseInfo.codProspectStatus.equals(selectedInfo.codProspectStatus));
	}
	
	
	
	@Override public List<StoprosInfo> merge(StoprosInfo baseInfo, ProstusInfo selectedInfo) {
		List<StoprosInfo> results = new ArrayList<>();
		
		baseInfo.txtProspectStatus = selectedInfo.txtProspectStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoprosInfo> getUniquifier() {
		return null;
	}
}
