package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class MultmoipVisiMergeSetupar implements InfoMergerVisitorV3<MultmoipInfo, SetuparInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, SetuparInfo selectedInfo) {
		return baseInfo.cusparData.codPayPartner == selectedInfo.codPayPartner;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
