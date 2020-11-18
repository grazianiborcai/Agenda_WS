package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecardVisiMergeCuspar extends InfoMergerVisitorTemplate<CrecardInfo, CusparInfo> {
	
	@Override public List<CrecardInfo> beforeMerge(List<CrecardInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CrecardInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner &&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer	);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CusparInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CrecardInfo> getUniquifier() {
		return null;
	}
}
