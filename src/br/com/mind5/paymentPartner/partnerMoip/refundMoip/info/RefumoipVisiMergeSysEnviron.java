package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefumoipVisiMergeSysEnviron implements InfoMergerVisitorV3<RefumoipInfo, SysEnvironInfo> {
	
	@Override public List<RefumoipInfo> beforeMerge(List<RefumoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefumoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefumoipInfo> getUniquifier() {
		return null;
	}
}
