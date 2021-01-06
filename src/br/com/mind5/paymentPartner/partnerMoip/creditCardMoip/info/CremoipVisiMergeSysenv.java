package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class CremoipVisiMergeSysenv extends InfoMergerVisitorTemplate<CremoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(CremoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
}
