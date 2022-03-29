package br.com.mind5.business.personList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PersolisMergerVisiPerbiolis extends InfoMergerVisitorTemplate<PersolisInfo, PerbiolisInfo> {

	@Override public boolean shouldMerge(PersolisInfo baseInfo, PerbiolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner		&&
				baseInfo.codPerson == selectedInfo.codPerson		);
	}
	
	

	@Override public List<PersolisInfo> merge(PersolisInfo baseInfo, PerbiolisInfo selectedInfo) {
		List<PersolisInfo> results = new ArrayList<>();
		
		baseInfo.perbiolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
