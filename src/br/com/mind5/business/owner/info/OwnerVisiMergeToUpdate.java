package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergeToUpdate extends InfoMergerVisitorTemplate<OwnerInfo, OwnerInfo> {

	@Override public boolean shouldMerge(OwnerInfo baseInfo, OwnerInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, OwnerInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		if (baseInfo.addresses != null)
			selectedInfo.addresses = baseInfo.addresses;
		
		if (baseInfo.phones != null)
			selectedInfo.phones = baseInfo.phones;
		
		if (baseInfo.companyData != null)
			selectedInfo.companyData = baseInfo.companyData;
		
		if (baseInfo.personData != null)
			selectedInfo.personData = baseInfo.personData;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
