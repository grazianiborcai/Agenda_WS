package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapVisiMergeFormone extends InfoMergerVisitorTemplate<PhonapInfo, FormoneInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, FormoneInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, FormoneInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		baseInfo.codForm = selectedInfo.codForm;
		
		results.add(baseInfo);
		return results;
	}
}
