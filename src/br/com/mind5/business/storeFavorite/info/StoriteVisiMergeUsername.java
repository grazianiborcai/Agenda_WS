package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoriteVisiMergeUsername implements InfoMergerVisitorV3<StoriteInfo, UsernameInfo> {
	
	@Override public List<StoriteInfo> beforeMerge(List<StoriteInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoriteInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StoriteInfo> merge(StoriteInfo baseInfo, UsernameInfo selectedInfo) {
		List<StoriteInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoriteInfo> getUniquifier() {
		return null;
	}
}
