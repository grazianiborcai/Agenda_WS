package br.com.mind5.masterData.materialSubgroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

final class MatubupVisiMergeMatubuparch implements InfoMergerVisitorV3<MatubupInfo, MatubuparchInfo> {
	
	@Override public List<MatubupInfo> beforeMerge(List<MatubupInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatubupInfo baseInfo, MatubuparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MatubupInfo> merge(MatubupInfo baseInfo, MatubuparchInfo selectedInfo) {
		List<MatubupInfo> results = new ArrayList<>();
		
		MatubupInfo result = MatubupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatubupInfo> getUniquifier() {
		return null;
	}
}
