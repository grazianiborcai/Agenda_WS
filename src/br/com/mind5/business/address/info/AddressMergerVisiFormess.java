package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressMergerVisiFormess extends InfoMergerVisitorTemplate<AddressInfo, FormessInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, FormessInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, FormessInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
}
