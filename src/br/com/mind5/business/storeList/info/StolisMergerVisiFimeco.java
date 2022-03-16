package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerVisiFimeco extends InfoMergerVisitorTemplate<StolisInfo, FimecoInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, FimecoInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codStore 	== selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, FimecoInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.fimecoData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
