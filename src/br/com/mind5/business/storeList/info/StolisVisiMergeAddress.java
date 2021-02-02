package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeAddress extends InfoMergerVisitorTemplate<StolisInfo, AddressInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, AddressInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.addressData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
