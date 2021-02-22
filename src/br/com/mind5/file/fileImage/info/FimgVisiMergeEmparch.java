package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgVisiMergeEmparch extends InfoMergerVisitorTemplate<FimgInfo, EmparchInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, EmparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, EmparchInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.codEmployee = selectedInfo.codEmployee;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
