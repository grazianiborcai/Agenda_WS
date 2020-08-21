package br.com.mind5.masterData.materialSubgroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

final class MatubupVisiMergeMatouparch implements InfoMergerVisitorV3<MatubupInfo, MatouparchInfo> {
	
	@Override public List<MatubupInfo> beforeMerge(List<MatubupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatubupInfo baseInfo, MatouparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MatubupInfo> merge(MatubupInfo baseInfo, MatouparchInfo selectedInfo) {
		List<MatubupInfo> results = new ArrayList<>();
		
		MatubupInfo result = MatubupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatubupInfo> getUniquifier() {
		return null;
	}
}
