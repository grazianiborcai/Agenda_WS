package br.com.mind5.masterData.materialGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

final class MatoupVisiMergeBusarea implements InfoMergerVisitorV3<MatoupInfo, BusareaInfo> {
	
	@Override public List<MatoupInfo> beforeMerge(List<MatoupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatoupInfo baseInfo, BusareaInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<MatoupInfo> merge(MatoupInfo baseInfo, BusareaInfo selectedInfo) {
		List<MatoupInfo> results = new ArrayList<>();
		
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatoupInfo> getUniquifier() {
		return null;
	}
}
