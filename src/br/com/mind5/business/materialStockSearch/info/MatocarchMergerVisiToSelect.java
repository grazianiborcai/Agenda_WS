package br.com.mind5.business.materialStockSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatocarchMergerVisiToSelect extends InfoMergerVisitorTemplate<MatocarchInfo, MatocarchInfo> {

	@Override public boolean shouldMerge(MatocarchInfo baseInfo, MatocarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MatocarchInfo> merge(MatocarchInfo baseInfo, MatocarchInfo selectedInfo) {
		List<MatocarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
