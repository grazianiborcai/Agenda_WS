package br.com.mind5.business.storeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class SotarchVisiMergeUsername implements InfoMergerVisitor<SotarchInfo, UsernameInfo> {
	
	@Override public List<SotarchInfo> beforeMerge(List<SotarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SotarchInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<SotarchInfo> merge(SotarchInfo baseInfo, UsernameInfo selectedInfo) {
		List<SotarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SotarchInfo> getUniquifier() {
		return null;
	}
}
