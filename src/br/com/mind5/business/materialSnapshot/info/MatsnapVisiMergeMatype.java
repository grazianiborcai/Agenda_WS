package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

final class MatsnapVisiMergeMatype extends InfoMergerVisitorTemplate<MatsnapInfo, MatypeInfo> {
	
	@Override public List<MatsnapInfo> beforeMerge(List<MatsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatypeInfo selectedInfo) {
		return (baseInfo.codType == selectedInfo.codType);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatypeInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtType = selectedInfo.txtType;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatsnapInfo> getUniquifier() {
		return null;
	}
}
