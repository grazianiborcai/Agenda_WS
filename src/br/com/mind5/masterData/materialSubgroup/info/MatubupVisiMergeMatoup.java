package br.com.mind5.masterData.materialSubgroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatubupVisiMergeMatoup implements InfoMergerVisitor<MatubupInfo, MatoupInfo> {
	
	@Override public List<MatubupInfo> beforeMerge(List<MatubupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatubupInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatubupInfo> merge(MatubupInfo baseInfo, MatoupInfo selectedInfo) {
		List<MatubupInfo> results = new ArrayList<>();
		
		baseInfo.codGroup = selectedInfo.codGroup;
		baseInfo.txtGroup = selectedInfo.txtGroup;		
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatubupInfo> getUniquifier() {
		return null;
	}
}
