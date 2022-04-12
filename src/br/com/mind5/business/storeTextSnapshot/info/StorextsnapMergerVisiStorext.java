package br.com.mind5.business.storeTextSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorextsnapMergerVisiStorext extends InfoMergerVisitorTemplate<StorextsnapInfo, StorextInfo> {

	@Override public boolean shouldMerge(StorextsnapInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StorextsnapInfo> merge(StorextsnapInfo baseInfo, StorextInfo selectedInfo) {
		List<StorextsnapInfo> results = new ArrayList<>();
		
		StorextsnapInfo result = StorextsnapInfo.copyFrom(selectedInfo);		
		result.codSnapshot = baseInfo.codSnapshot;		
		
		results.add(result);
		return results;
	}
}
