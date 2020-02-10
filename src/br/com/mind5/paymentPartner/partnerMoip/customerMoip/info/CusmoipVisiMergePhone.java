package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusmoipVisiMergePhone implements InfoMergerVisitorV3<CusmoipInfo, PhoneInfo> {
	
	@Override public List<CusmoipInfo> beforeMerge(List<CusmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusmoipInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codPhone	== selectedInfo.codPhone		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, PhoneInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.phoneData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusmoipInfo> getUniquifier() {
		return null;
	}
}
