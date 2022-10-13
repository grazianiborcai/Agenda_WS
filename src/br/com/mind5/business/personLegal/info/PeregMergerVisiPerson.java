package br.com.mind5.business.personLegal.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PeregMergerVisiPerson extends InfoMergerVisitorTemplate<PeregInfo, PersonInfo> {

	@Override public boolean shouldMerge(PeregInfo baseInfo, PersonInfo selectedInfo) {
		if (baseInfo.codOwner != selectedInfo.codOwner)
			return false;
		
		if (baseInfo.codStore != selectedInfo.codStore)
			return false;
		
		if (baseInfo.codPerson <= 0)
			return true;
		
		return (baseInfo.codPerson == selectedInfo.codPerson);
	}
	
	
	
	@Override public List<PeregInfo> merge(PeregInfo baseInfo, PersonInfo selectedInfo) {
		List<PeregInfo> results = new ArrayList<>();
		
		baseInfo.personData = selectedInfo;
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
}
