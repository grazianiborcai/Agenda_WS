package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class PaymoipVisiMergeSysenv extends InfoMergerVisitorTemplate<PaymoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
}
