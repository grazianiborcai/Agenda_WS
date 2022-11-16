package br.com.mind5.business.personLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PeregMergerVisiToUpdate extends InfoMergerVisitorTemplate<PeregInfo, PeregInfo> {

	@Override public boolean shouldMerge(PeregInfo baseInfo, PeregInfo selectedInfo) {
		return (baseInfo.codOwner    	== selectedInfo.codOwner &&
				baseInfo.codLegalPerson == selectedInfo.codLegalPerson	);
	}
	
	
	
	@Override public List<PeregInfo> merge(PeregInfo baseInfo, PeregInfo selectedInfo) {
		List<PeregInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.codPerson = selectedInfo.codPerson;		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
}
