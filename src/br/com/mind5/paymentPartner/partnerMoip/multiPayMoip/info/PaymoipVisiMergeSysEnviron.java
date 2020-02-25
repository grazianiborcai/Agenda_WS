package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PaymoipVisiMergeSysEnviron implements InfoMergerVisitorV3<PaymoipInfo, SysEnvironInfo> {
	
	@Override public List<PaymoipInfo> beforeMerge(List<PaymoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaymoipInfo> getUniquifier() {
		return null;
	}
}
