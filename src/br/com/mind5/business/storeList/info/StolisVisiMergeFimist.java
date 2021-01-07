package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeFimist extends InfoMergerVisitorTemplate<StolisInfo, FimistInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codStore 	== selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, FimistInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.fimistes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolisInfo> getUniquifier() {
		return new StolisUniquifier();
	}
}
