package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusmoipVisiMergeAddress implements InfoMergerVisitorV3<CusmoipInfo, AddressInfo> {
	
	@Override public List<CusmoipInfo> beforeMerge(List<CusmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusmoipInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codAddress	== selectedInfo.codAddress		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, AddressInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.addressData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusmoipInfo> getUniquifier() {
		return null;
	}
}
