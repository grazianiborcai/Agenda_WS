package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusVisiMergeAddress implements InfoMergerVisitorV3<CusInfo, AddressInfo> {
	
	@Override public List<CusInfo> beforeMerge(List<CusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&& 
				baseInfo.codCustomer == selectedInfo.codCustomer		);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, AddressInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusInfo> getUniquifier() {
		return null;
	}
}
