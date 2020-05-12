package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

final class CusparVisiMergeCusparch implements InfoMergerVisitorV3<CusparInfo, CusparchInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, CusparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CusparchInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		CusparInfo result = CusparInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
