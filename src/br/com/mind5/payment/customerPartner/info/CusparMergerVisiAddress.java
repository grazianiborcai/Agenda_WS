package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiAddress extends InfoMergerVisitorTemplate<CusparInfo, AddressInfo> {

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
}
