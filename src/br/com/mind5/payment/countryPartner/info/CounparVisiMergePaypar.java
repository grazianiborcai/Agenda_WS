package br.com.mind5.payment.countryPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class CounparVisiMergePaypar implements InfoMergerVisitorV3<CounparInfo, PayparInfo> {
	
	@Override public List<CounparInfo> beforeMerge(List<CounparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CounparInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CounparInfo> merge(CounparInfo baseInfo, PayparInfo selectedInfo) {
		List<CounparInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CounparInfo> getUniquifier() {
		return null;
	}
}
