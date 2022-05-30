package br.com.mind5.security.userList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UselisMergerVisiPersolis extends InfoMergerVisitorTemplate<UselisInfo, PersolisInfo> {	
	
	@Override public boolean shouldMerge(UselisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson);
	}
	
	

	@Override public List<UselisInfo> merge(UselisInfo baseInfo, PersolisInfo selectedInfo) {
		List<UselisInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
