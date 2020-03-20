package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeForm implements InfoMergerVisitorV3<AddressInfo, FormAddressInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, FormAddressInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, FormAddressInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
