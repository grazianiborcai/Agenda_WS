package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class RefumoipVisiMergeSysenv implements InfoMergerVisitorV3<RefumoipInfo, SysenvInfo> {
	
	@Override public List<RefumoipInfo> beforeMerge(List<RefumoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefumoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefumoipInfo> getUniquifier() {
		return null;
	}
}
