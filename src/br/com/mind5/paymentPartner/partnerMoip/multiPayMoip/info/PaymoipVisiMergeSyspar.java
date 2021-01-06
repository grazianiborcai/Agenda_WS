package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class PaymoipVisiMergeSyspar extends InfoMergerVisitorTemplate<PaymoipInfo, SysparInfo> {

	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SysparInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
