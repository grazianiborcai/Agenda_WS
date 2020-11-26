package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemrapVisiMergeMatsnap extends InfoMergerVisitorTemplate<OrdemrapInfo, MatsnapInfo> {

	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, MatsnapInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner  && 
				baseInfo.codMat  		== selectedInfo.codMat	  &&
				baseInfo.codMatSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, MatsnapInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.matData = MatInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
