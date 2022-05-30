package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerVisiPersonap extends InfoMergerVisitorTemplate<UserapInfo, PersonapInfo> {

	@Override public boolean shouldMerge(UserapInfo baseInfo, PersonapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<UserapInfo> merge(UserapInfo baseInfo, PersonapInfo selectedInfo) {
		List<UserapInfo> results = new ArrayList<>();
		
		baseInfo.personData = selectedInfo;
		baseInfo.codPerson = selectedInfo.codPerson;
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserapInfo> uniquifyHook(List<UserapInfo> results) {
		InfoUniquifier<UserapInfo> uniquifier = new UserapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
