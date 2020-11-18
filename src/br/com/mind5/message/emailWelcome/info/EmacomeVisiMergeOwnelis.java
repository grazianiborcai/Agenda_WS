package br.com.mind5.message.emailWelcome.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmacomeVisiMergeOwnelis extends InfoMergerVisitorTemplate<EmacomeInfo, OwnelisInfo> {
	
	@Override public List<EmacomeInfo> beforeMerge(List<EmacomeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmacomeInfo baseInfo, OwnelisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<EmacomeInfo> merge(EmacomeInfo baseInfo, OwnelisInfo selectedInfo) {
		List<EmacomeInfo> results = new ArrayList<>();
		
		baseInfo.ownelisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmacomeInfo> getUniquifier() {
		return null;
	}
}
