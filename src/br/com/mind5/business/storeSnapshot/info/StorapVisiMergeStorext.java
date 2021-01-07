package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeStorext extends InfoMergerVisitorTemplate<StorapInfo, StorextInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, StorextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, StorextInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.storextsnapes.add(StorextsnapInfo.copyFrom(selectedInfo));
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
