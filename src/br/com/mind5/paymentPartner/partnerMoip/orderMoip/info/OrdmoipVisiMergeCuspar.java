package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class OrdmoipVisiMergeCuspar extends InfoMergerVisitorTemplate<OrdmoipInfo, CusparInfo> {
	
	@Override public List<OrdmoipInfo> beforeMerge(List<OrdmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner    				  == selectedInfo.codOwner &&
				baseInfo.payordistData.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, CusparInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.cusparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdmoipInfo> getUniquifier() {
		return null;
	}
}
