package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmposMergerVisiEmplres extends InfoMergerVisitorTemplate<EmposInfo, EmplresInfo> {

	@Override public boolean shouldMerge(EmposInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codEmployee == selectedInfo.codEmployee  );
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, EmplresInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.emplresData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
