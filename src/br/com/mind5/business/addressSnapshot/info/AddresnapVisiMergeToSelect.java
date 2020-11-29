package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddresnapVisiMergeToSelect extends InfoMergerVisitorTemplate<AddresnapInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, AddresnapInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.lastChangedBy = baseInfo.lastChangedBy;	// TODO: precisa disso mesmo ?
		
		results.add(selectedInfo);
		return results;
	}
}
