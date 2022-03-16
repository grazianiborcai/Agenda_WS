package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerVisiPhone extends InfoMergerVisitorTemplate<StolisInfo, PhoneInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner 	&&
				baseInfo.codStore 	== selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, PhoneInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
