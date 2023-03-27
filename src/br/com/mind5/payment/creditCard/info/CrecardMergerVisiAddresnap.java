package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CrecardMergerVisiAddresnap extends InfoMergerVisitorTemplate<CrecardInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner           	  == selectedInfo.codOwner   &&
				baseInfo.codAddressHolder         == selectedInfo.codAddress &&
				baseInfo.codAddressSnapshotHolder == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, AddresnapInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.addresnapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
