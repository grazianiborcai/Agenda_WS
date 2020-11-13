package br.com.mind5.message.emailWelcome.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmacomeVisiMergeUselis implements InfoMergerVisitor<EmacomeInfo, UselisInfo> {
	
	@Override public List<EmacomeInfo> beforeMerge(List<EmacomeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmacomeInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser == selectedInfo.codUser);
	}
	
	
	
	@Override public List<EmacomeInfo> merge(EmacomeInfo baseInfo, UselisInfo selectedInfo) {
		List<EmacomeInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo.persolisData;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmacomeInfo> getUniquifier() {
		return null;
	}
}
