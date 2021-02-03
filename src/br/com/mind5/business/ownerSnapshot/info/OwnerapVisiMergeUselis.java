package br.com.mind5.business.ownerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class OwnerapVisiMergeUselis extends InfoMergerVisitorTemplate<OwnerapInfo, UselisInfo> {

	@Override public boolean shouldMerge(OwnerapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<OwnerapInfo> merge(OwnerapInfo baseInfo, UselisInfo selectedInfo) {
		List<OwnerapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
