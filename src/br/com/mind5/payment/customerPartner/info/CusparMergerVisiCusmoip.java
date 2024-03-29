package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

final class CusparMergerVisiCusmoip extends InfoMergerVisitorTemplate<CusparInfo, CusmoipInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, CusmoipInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner	&&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer	);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CusmoipInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.customerId = selectedInfo.customerId;
		baseInfo.customerLink = selectedInfo.customerLink;
		baseInfo.accountLink = selectedInfo.accountLink;	
		
		results.add(baseInfo);
		return results;
	}
}
