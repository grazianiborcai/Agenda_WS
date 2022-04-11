package br.com.mind5.business.ownerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnerapMergerVisiPersolis extends InfoMergerVisitorTemplate<OwnerapInfo, PersolisInfo> {

	@Override public boolean shouldMerge(OwnerapInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<OwnerapInfo> merge(OwnerapInfo baseInfo, PersolisInfo selectedInfo) {
		List<OwnerapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
