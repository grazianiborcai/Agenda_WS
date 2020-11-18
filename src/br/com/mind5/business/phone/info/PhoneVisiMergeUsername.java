package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class PhoneVisiMergeUsername extends InfoMergerVisitorTemplate<PhoneInfo, UsernameInfo> {
	
	@Override public List<PhoneInfo> beforeMerge(List<PhoneInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhoneInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, UsernameInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhoneInfo> getUniquifier() {
		return null;
	}
}
