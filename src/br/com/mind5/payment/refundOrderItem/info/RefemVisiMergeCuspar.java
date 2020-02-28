package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class RefemVisiMergeCuspar implements InfoMergerVisitorV3<RefemInfo, CusparInfo> {
	
	@Override public List<RefemInfo> beforeMerge(List<RefemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefemInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner	&&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, CusparInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.cusparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefemInfo> getUniquifier() {
		return null;
	}
}
