package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class CusparVisiMergeUserap implements InfoMergerVisitorV3<CusparInfo, UserapInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, UserapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner		&&
				baseInfo.codUser 			== selectedInfo.codUser			&&
				baseInfo.codUserSnapshot	== selectedInfo.codSnapshot			);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, UserapInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.userapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
