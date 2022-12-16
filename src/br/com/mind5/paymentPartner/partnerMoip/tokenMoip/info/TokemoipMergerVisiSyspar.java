package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

final class TokemoipMergerVisiSyspar extends InfoMergerVisitorTemplate<TokemoipInfo, MktparInfo> {

	@Override public boolean shouldMerge(TokemoipInfo baseInfo, MktparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, MktparInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
