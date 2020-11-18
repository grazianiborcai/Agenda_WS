package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordVisiMergeCrecard extends InfoMergerVisitorTemplate<PayordInfo, CrecardInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 	 	== selectedInfo.codOwner		&&
				baseInfo.codCreditCard  == selectedInfo.codCreditCard		);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.codPayCustomer = selectedInfo.codPayCustomer;
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
