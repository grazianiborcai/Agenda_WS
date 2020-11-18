package br.com.mind5.business.orderSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrdnapVisiMergeCuslis extends InfoMergerVisitorTemplate<OrdnapInfo, CuslisInfo> {
	
	@Override public List<OrdnapInfo> beforeMerge(List<OrdnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdnapInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner     == selectedInfo.codOwner &&
				baseInfo.codCustomer  == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<OrdnapInfo> merge(OrdnapInfo baseInfo, CuslisInfo selectedInfo) {
		List<OrdnapInfo> results = new ArrayList<>();
		
		baseInfo.codCustomerSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdnapInfo> getUniquifier() {
		return null;
	}
}
