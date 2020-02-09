package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusparVisiMergeAddresnap implements InfoMergerVisitorV3<CusparInfo, AddresnapInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner    		== selectedInfo.codOwner	&&
				baseInfo.codAddress  		== selectedInfo.codAddress	&&
				baseInfo.codAddressSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, AddresnapInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.addresnapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
