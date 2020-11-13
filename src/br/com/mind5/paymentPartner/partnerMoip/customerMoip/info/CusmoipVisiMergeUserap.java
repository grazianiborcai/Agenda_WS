package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class CusmoipVisiMergeUserap implements InfoMergerVisitor<CusmoipInfo, UserapInfo> {
	
	@Override public List<CusmoipInfo> beforeMerge(List<CusmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusmoipInfo baseInfo, UserapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner	&&
				baseInfo.codUserSnapshot	== selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, UserapInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.userapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusmoipInfo> getUniquifier() {
		return null;
	}
}
