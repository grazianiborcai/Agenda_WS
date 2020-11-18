package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class PayordVisiMergePaypar extends InfoMergerVisitorTemplate<PayordInfo, PayparInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, PayparInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner; 
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
