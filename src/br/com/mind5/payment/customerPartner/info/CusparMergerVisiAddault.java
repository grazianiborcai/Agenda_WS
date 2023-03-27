package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiAddault extends InfoMergerVisitorTemplate<CusparInfo, AddaultInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, AddaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser	);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, AddaultInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codAddress         = selectedInfo.codAddress;
		baseInfo.codAddressSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
