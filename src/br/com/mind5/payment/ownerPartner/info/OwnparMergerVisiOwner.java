package br.com.mind5.payment.ownerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnparMergerVisiOwner extends InfoMergerVisitorTemplate<OwnparInfo, OwnerInfo> {

	@Override public boolean shouldMerge(OwnparInfo baseInfo, OwnerInfo selectedInfo) {
		return (selectedInfo != null && selectedInfo.companyData != null );
	}
	
	
	
	@Override public List<OwnparInfo> merge(OwnparInfo baseInfo, OwnerInfo selectedInfo) {
		List<OwnparInfo> results = new ArrayList<>();
		
		baseInfo.codOwner = selectedInfo.codOwner;
		baseInfo.codCountry = selectedInfo.companyData.codCountryLegal;
		baseInfo.txtCountry = selectedInfo.companyData.txtCountryLegal;
		
		results.add(baseInfo);
		return results;
	}
}
