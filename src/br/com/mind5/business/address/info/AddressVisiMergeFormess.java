package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeFormess extends InfoMergerVisitorTemplate<AddressInfo, FormessInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, FormessInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, FormessInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}
