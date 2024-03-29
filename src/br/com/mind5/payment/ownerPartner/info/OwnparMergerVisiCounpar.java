package br.com.mind5.payment.ownerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class OwnparMergerVisiCounpar extends InfoMergerVisitorTemplate<OwnparInfo, CounparInfo> {

	@Override public boolean shouldMerge(OwnparInfo baseInfo, CounparInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry));
	}
	
	
	
	@Override public List<OwnparInfo> merge(OwnparInfo baseInfo, CounparInfo selectedInfo) {
		List<OwnparInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner;
		baseInfo.isDefault = selectedInfo.isDefault;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
}
