package br.com.mind5.file.fileImageList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class FimistVisiMergeFimarch implements InfoMergerVisitorV3<FimistInfo, FimarchInfo> {
	
	@Override public List<FimistInfo> beforeMerge(List<FimistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FimistInfo baseInfo, FimarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimistInfo> merge(FimistInfo baseInfo, FimarchInfo selectedInfo) {
		List<FimistInfo> results = new ArrayList<>();
		
		FimistInfo result = FimistInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FimistInfo> getUniquifier() {
		return null;
	}
}
