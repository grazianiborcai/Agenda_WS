package br.com.mind5.message.emailPasswordChange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmordeVisiMergeUselis implements InfoMergerVisitor<EmordeInfo, UselisInfo> {
	
	@Override public List<EmordeInfo> beforeMerge(List<EmordeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmordeInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser == selectedInfo.codUser);
	}
	
	
	
	@Override public List<EmordeInfo> merge(EmordeInfo baseInfo, UselisInfo selectedInfo) {
		List<EmordeInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo.persolisData;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmordeInfo> getUniquifier() {
		return null;
	}
}
