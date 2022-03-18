package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatMergerVisiMateg extends InfoMergerVisitorTemplate<MatInfo, MategInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MategInfo selectedInfo) {
		return (baseInfo.codMatCateg == selectedInfo.codMatCateg);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MategInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtMatCateg = baseInfo.txtMatCateg;
		
		results.add(baseInfo);
		return results;
	}
}
