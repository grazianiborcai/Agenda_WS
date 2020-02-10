package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class CusmoipVisiMergeUselis implements InfoMergerVisitorV3<CusmoipInfo, UselisInfo> {
	
	@Override public List<CusmoipInfo> beforeMerge(List<CusmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusmoipInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codUser	== selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, UselisInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.uselisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusmoipInfo> getUniquifier() {
		return null;
	}
}
