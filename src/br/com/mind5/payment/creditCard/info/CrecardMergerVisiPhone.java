package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CrecardMergerVisiPhone extends InfoMergerVisitorTemplate<CrecardInfo, PhoneInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner &&
				baseInfo.codPhoneHolder == selectedInfo.codPhone	);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, PhoneInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codPhoneSnapshotHolder = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
