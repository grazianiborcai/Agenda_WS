package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeCusarch extends InfoMergerVisitorTemplate<FimgInfo, CusarchInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, CusarchInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.MANY_TO_MANY;
	}
}
