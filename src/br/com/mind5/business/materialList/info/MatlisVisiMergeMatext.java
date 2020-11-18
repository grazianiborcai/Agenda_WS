package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatlisVisiMergeMatext extends InfoMergerVisitorTemplate<MatlisInfo, MatextInfo> {
	
	@Override public List<MatlisInfo> beforeMerge(List<MatlisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatextInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtMat = selectedInfo.txtMat;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatlisInfo> getUniquifier() {
		return null;
	}
}
