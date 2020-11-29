package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddresnapVisiMergeFormess extends InfoMergerVisitorTemplate<AddresnapInfo, FormessInfo> {

	@Override public boolean shouldMerge(AddresnapInfo baseInfo, FormessInfo selectedInfo) {
		return (baseInfo.codCountry.equals(selectedInfo.codCountry));
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, FormessInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
}
