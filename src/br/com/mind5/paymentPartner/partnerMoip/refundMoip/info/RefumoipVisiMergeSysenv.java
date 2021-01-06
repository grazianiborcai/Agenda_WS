package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class RefumoipVisiMergeSysenv extends InfoMergerVisitorTemplate<RefumoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(RefumoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
}
