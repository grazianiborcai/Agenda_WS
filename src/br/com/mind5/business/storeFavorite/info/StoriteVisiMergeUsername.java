package br.com.mind5.business.storeFavorite.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoriteVisiMergeUsername extends InfoMergerVisitorTemplate<StoriteInfo, UsernameInfo> {

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
}
