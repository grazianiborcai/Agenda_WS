package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class PetVisiMergeUsername extends InfoMergerVisitorTemplate<PerbioInfo, UsernameInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, UsernameInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
