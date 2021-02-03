package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CrecardVisiMergeAddress extends InfoMergerVisitorTemplate<CrecardInfo, AddressInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 		  == selectedInfo.codOwner &&
				baseInfo.codAddressHolder == selectedInfo.codAddress	);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, AddressInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codAddressSnapshotHolder = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
