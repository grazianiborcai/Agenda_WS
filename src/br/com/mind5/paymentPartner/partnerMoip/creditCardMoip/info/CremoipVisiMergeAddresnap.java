package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CremoipVisiMergeAddresnap implements InfoMergerVisitorV3<CremoipInfo, AddresnapInfo> {
	
	@Override public List<CremoipInfo> beforeMerge(List<CremoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CremoipInfo> getUniquifier() {
		return null;
	}
}
