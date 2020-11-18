package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StorextVisiMergeUsername extends InfoMergerVisitorTemplate<StorextInfo, UsernameInfo> {
	
	@Override public List<StorextInfo> beforeMerge(List<StorextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, UsernameInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextInfo> getUniquifier() {
		return null;
	}
}
