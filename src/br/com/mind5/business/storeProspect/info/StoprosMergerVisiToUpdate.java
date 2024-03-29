package br.com.mind5.business.storeProspect.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoprosMergerVisiToUpdate extends InfoMergerVisitorTemplate<StoprosInfo, StoprosInfo> {

	@Override public boolean shouldMerge(StoprosInfo baseInfo, StoprosInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStoreProspect == selectedInfo.codStoreProspect		);
	}
	
	
	
	@Override public List<StoprosInfo> merge(StoprosInfo baseInfo, StoprosInfo selectedInfo) {
		List<StoprosInfo> results = new ArrayList<>();
		
		baseInfo.prospectEmail = selectedInfo.prospectEmail;
		baseInfo.prospectName = selectedInfo.prospectName;
		baseInfo.prospectPhone = selectedInfo.prospectPhone;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
}
