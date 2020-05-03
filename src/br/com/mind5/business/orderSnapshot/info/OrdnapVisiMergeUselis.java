package br.com.mind5.business.orderSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class OrdnapVisiMergeUselis implements InfoMergerVisitorV3<OrdnapInfo, UselisInfo> {
	
	@Override public List<OrdnapInfo> beforeMerge(List<OrdnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdnapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser		); 
	}
	
	
	
	@Override public List<OrdnapInfo> merge(OrdnapInfo baseInfo, UselisInfo selectedInfo) {
		List<OrdnapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdnapInfo> getUniquifier() {
		return null;
	}
}
