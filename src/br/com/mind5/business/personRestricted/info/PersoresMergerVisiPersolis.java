package br.com.mind5.business.personRestricted.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PersoresMergerVisiPersolis extends InfoMergerVisitorTemplate<PersoresInfo, PersolisInfo> {

	@Override public boolean shouldMerge(PersoresInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner		&&
				baseInfo.codPerson == selectedInfo.codPerson		);
	}
	
	

	@Override public List<PersoresInfo> merge(PersoresInfo baseInfo, PersolisInfo selectedInfo) {
		List<PersoresInfo> results = new ArrayList<>();
		
		PersoresInfo result = PersoresInfo.copyFrom(baseInfo);
		
		results.add(result);
		return results;
	}
}
