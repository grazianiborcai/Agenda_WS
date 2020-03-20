package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeState implements InfoMergerVisitorV3<AddressInfo, StateInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, StateInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, StateInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
