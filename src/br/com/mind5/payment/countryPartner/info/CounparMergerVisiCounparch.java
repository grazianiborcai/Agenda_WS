package br.com.mind5.payment.countryPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

final class CounparMergerVisiCounparch extends InfoMergerVisitorTemplate<CounparInfo, CounparchInfo> {

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
}
