package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusmoipVisiMergeAddresnap extends InfoMergerVisitorTemplate<CusmoipInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(CusmoipInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner	&&
				baseInfo.codAddressSnapshot	== selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, AddresnapInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.addresnapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
