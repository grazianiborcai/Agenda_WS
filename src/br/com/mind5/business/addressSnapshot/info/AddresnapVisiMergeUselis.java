package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class AddresnapVisiMergeUselis extends InfoMergerVisitorTemplate<AddresnapInfo, UselisInfo> {
	
	@Override public List<AddresnapInfo> beforeMerge(List<AddresnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddresnapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, UselisInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddresnapInfo> getUniquifier() {
		return null;
	}
}
