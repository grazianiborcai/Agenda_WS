package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyVisiMergeFimeco extends InfoMergerVisitorTemplate<StorbyInfo, FimecoInfo> {

	@Override public boolean shouldMerge(StorbyInfo baseInfo, FimecoInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, FimecoInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.fimecoData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
