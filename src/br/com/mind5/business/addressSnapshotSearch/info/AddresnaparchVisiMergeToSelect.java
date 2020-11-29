package br.com.mind5.business.addressSnapshotSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class AddresnaparchVisiMergeToSelect extends InfoMergerVisitorTemplate<AddresnaparchInfo, AddresnaparchInfo> {
	
	@Override public List<AddresnaparchInfo> beforeMerge(List<AddresnaparchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddresnaparchInfo baseInfo, AddresnaparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddresnaparchInfo> merge(AddresnaparchInfo baseInfo, AddresnaparchInfo selectedInfo) {
		List<AddresnaparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddresnaparchInfo> getUniquifier() {
		return null;
	}
}
