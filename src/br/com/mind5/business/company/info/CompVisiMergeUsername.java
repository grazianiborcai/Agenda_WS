package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CompVisiMergeUsername extends InfoMergerVisitorTemplate<CompInfo, UsernameInfo> {
	
	@Override public List<CompInfo> beforeMerge(List<CompInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<CompInfo> merge(CompInfo baseInfo, UsernameInfo selectedInfo) {
		List<CompInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompInfo> getUniquifier() {
		return null;
	}
}
