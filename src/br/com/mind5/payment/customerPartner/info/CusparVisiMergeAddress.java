package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CusparVisiMergeAddress extends InfoMergerVisitorTemplate<CusparInfo, AddressInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codAddress	== selectedInfo.codAddress		);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, AddressInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codAddressSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
