package br.com.mind5.business.orderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemistVisiMergeMatlis extends InfoMergerVisitorTemplate<OrdemistInfo, MatlisInfo> {

	@Override public boolean shouldMerge(OrdemistInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat == selectedInfo.codMat);
	}
	
	
	
	@Override public List<OrdemistInfo> merge(OrdemistInfo baseInfo, MatlisInfo selectedInfo) {
		List<OrdemistInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
