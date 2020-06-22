package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmulelVisiMergeStolis implements InfoMergerVisitorV3<EmulelInfo, StolisInfo> {
	
	@Override public List<EmulelInfo> beforeMerge(List<EmulelInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulelInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner ||
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<EmulelInfo> merge(EmulelInfo baseInfo, StolisInfo selectedInfo) {
		List<EmulelInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulelInfo> getUniquifier() {
		return null;
	}
}
