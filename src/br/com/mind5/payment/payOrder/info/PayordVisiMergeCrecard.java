package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordVisiMergeCrecard implements InfoMergerVisitorV3<PayordInfo, CrecardInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 	 	== selectedInfo.codOwner		&&
				baseInfo.codPayPartner  == selectedInfo.codPayPartner	&&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer		);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.crecardData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
