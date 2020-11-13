package br.com.mind5.masterData.materialGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

final class MatoupVisiMergeMatouparch implements InfoMergerVisitor<MatoupInfo, MatouparchInfo> {
	
	@Override public List<MatoupInfo> beforeMerge(List<MatoupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatoupInfo baseInfo, MatouparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MatoupInfo> merge(MatoupInfo baseInfo, MatouparchInfo selectedInfo) {
		List<MatoupInfo> results = new ArrayList<>();
		
		MatoupInfo result = MatoupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatoupInfo> getUniquifier() {
		return null;
	}
}
