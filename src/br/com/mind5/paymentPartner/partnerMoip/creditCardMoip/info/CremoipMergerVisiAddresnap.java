package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CremoipMergerVisiAddresnap extends InfoMergerVisitorTemplate<CremoipInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(CremoipInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner	&&
				baseInfo.codAddressSnapshot	== selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, AddresnapInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.addresnapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
