package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneMergerVisiToUpdate extends InfoMergerVisitorTemplate<PhoneInfo, PhoneInfo> {

	@Override public boolean shouldMerge(PhoneInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPhone == selectedInfo.codPhone		);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, PhoneInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.codUser 		= selectedInfo.codUser;
		baseInfo.codStore 		= selectedInfo.codStore;
		baseInfo.codSnapshot 	= selectedInfo.codSnapshot;
		baseInfo.codCustomer 	= selectedInfo.codCustomer;
		baseInfo.codEmployee 	= selectedInfo.codEmployee;
		baseInfo.codOwnerRef 	= selectedInfo.codOwnerRef;
		baseInfo.createdOn 		= selectedInfo.createdOn;
		baseInfo.createdBy 		= selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
}
