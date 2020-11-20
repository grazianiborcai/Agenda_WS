package br.com.mind5.file.fileImageList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimistVisiMergeFimarch extends InfoMergerVisitorTemplate<FimistInfo, FimarchInfo> {

	@Override public boolean shouldMerge(FimistInfo baseInfo, FimarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimistInfo> merge(FimistInfo baseInfo, FimarchInfo selectedInfo) {
		List<FimistInfo> results = new ArrayList<>();
		
		FimistInfo result = FimistInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
