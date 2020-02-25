package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class PaymoipVisiMergeSyspar implements InfoMergerVisitorV3<PaymoipInfo, SysparInfo> {
	
	@Override public List<PaymoipInfo> beforeMerge(List<PaymoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SysparInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaymoipInfo> getUniquifier() {
		return null;
	}
}
