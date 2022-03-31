package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddresnapMergerVisiAddresnaparch extends InfoMergerVisitorTemplate<AddresnapInfo, AddresnaparchInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, AddresnaparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, AddresnaparchInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		AddresnapInfo result = AddresnapInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
