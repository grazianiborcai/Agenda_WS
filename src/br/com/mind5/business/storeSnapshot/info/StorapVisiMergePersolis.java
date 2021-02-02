package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergePersolis extends InfoMergerVisitorTemplate<StorapInfo, PersolisInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, PersolisInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
