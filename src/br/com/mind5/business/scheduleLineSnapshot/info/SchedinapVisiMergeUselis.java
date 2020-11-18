package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class SchedinapVisiMergeUselis extends InfoMergerVisitorTemplate<SchedinapInfo, UselisInfo> {
	
	@Override public List<SchedinapInfo> beforeMerge(List<SchedinapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedinapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, UselisInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedinapInfo> getUniquifier() {
		return null;
	}
}
