package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatlisVisiMergeMateg extends InfoMergerVisitorTemplate<MatlisInfo, MategInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MategInfo selectedInfo) {
		return (baseInfo.codMatCateg == selectedInfo.codMatCateg);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MategInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtMatCateg = selectedInfo.txtMatCateg;
		
		results.add(baseInfo);
		return results;
	}
}
