package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatlisVisiMergeMateg implements InfoMergerVisitorV3<MatlisInfo, MategInfo> {
	
	@Override public List<MatlisInfo> beforeMerge(List<MatlisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MategInfo selectedInfo) {
		return (baseInfo.codMatCateg == selectedInfo.codMatCateg);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MategInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtMatCateg = selectedInfo.txtMatCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatlisInfo> getUniquifier() {
		return null;
	}
}