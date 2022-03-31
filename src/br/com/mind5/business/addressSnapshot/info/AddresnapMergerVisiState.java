package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.state.info.StateInfo;

final class AddresnapMergerVisiState extends InfoMergerVisitorTemplate<AddresnapInfo, StateInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, StateInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, StateInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.txtState = selectedInfo.txtState;
		
		results.add(baseInfo);
		return results;
	}
}
