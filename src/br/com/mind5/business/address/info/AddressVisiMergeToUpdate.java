package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeToUpdate implements InfoMergerVisitorV3<AddressInfo, AddressInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner &&
				baseInfo.codAddress == selectedInfo.codAddress);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, AddressInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		baseInfo.codEmployee = selectedInfo.codEmployee;
		baseInfo.codOwnerRef = selectedInfo.codOwnerRef;
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
