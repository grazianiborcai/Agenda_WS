package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class TokemoipVisiMergeSyspar implements InfoMergerVisitorV3<TokemoipInfo, SysparInfo> {
	
	@Override public List<TokemoipInfo> beforeMerge(List<TokemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(TokemoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, SysparInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}

	
	
	@Override public InfoUniquifier<TokemoipInfo> getUniquifier() {
		return null;
	}
}
