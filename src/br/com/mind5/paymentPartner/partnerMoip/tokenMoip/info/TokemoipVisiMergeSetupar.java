package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class TokemoipVisiMergeSetupar extends InfoMergerVisitorTemplate<TokemoipInfo, SetuparInfo> {

	@Override public boolean shouldMerge(TokemoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
