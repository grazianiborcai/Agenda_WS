package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class TokemoipVisiMergeSyspar extends InfoMergerVisitorTemplate<TokemoipInfo, SysparInfo> {

	@Override public boolean shouldMerge(TokemoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, SysparInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
