package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CremoipVisiMergeCuspar extends InfoMergerVisitorTemplate<CremoipInfo, CusparInfo> {
	
	@Override public List<CremoipInfo> beforeMerge(List<CremoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CremoipInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner 		&&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer		);
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, CusparInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.cusparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CremoipInfo> getUniquifier() {
		return null;
	}
}
