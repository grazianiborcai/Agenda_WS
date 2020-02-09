package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class CusparVisiMergeUselis implements InfoMergerVisitorV3<CusparInfo, UselisInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codUser 	== selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, UselisInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
