package br.com.mind5.business.planingData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PlanataVisiMergeMatice extends InfoMergerVisitorTemplate<PlanataInfo, MaticeInfo> {

	@Override public boolean shouldMerge(PlanataInfo baseInfo, MaticeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codStore == selectedInfo.codStore	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	

	@Override public List<PlanataInfo> merge(PlanataInfo baseInfo, MaticeInfo selectedInfo) {
		List<PlanataInfo> results = new ArrayList<>();
		
		baseInfo.price = selectedInfo.price;
		baseInfo.codCurr = selectedInfo.codCurr;
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
