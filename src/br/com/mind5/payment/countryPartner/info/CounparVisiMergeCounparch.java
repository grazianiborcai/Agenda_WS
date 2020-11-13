package br.com.mind5.payment.countryPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

final class CounparVisiMergeCounparch implements InfoMergerVisitor<CounparInfo, CounparchInfo> {
	
	@Override public List<CounparInfo> beforeMerge(List<CounparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CounparInfo baseInfo, CounparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CounparInfo> merge(CounparInfo baseInfo, CounparchInfo selectedInfo) {
		List<CounparInfo> results = new ArrayList<>();
		CounparInfo result = new CounparInfo();
		
		result = CounparInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CounparInfo> getUniquifier() {
		return null;
	}
}
