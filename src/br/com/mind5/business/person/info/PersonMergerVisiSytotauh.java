package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PersonMergerVisiSytotauh extends InfoMergerVisitorTemplate<PersonInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(PersonInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, SytotauhInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
