package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusnapMergerVisiPerson extends InfoMergerVisitorTemplate<CusnapInfo, PersonInfo> {

	@Override public boolean shouldMerge(CusnapInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<CusnapInfo> merge(CusnapInfo baseInfo, PersonInfo selectedInfo) {
		List<CusnapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
