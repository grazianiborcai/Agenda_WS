package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatsnapVisiMergeMateg extends InfoMergerVisitorTemplate<MatsnapInfo, MategInfo> {
	
	@Override public List<MatsnapInfo> beforeMerge(List<MatsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MategInfo selectedInfo) {
		return (baseInfo.codMatCateg == selectedInfo.codMatCateg);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MategInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtMatCateg = selectedInfo.txtMatCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatsnapInfo> getUniquifier() {
		return null;
	}
}
