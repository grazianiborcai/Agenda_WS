package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PayordVisiMergeCuspar implements InfoMergerVisitorV3<PayordInfo, CusparInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner	&&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, CusparInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
