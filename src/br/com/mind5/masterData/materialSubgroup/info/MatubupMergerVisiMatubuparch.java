package br.com.mind5.masterData.materialSubgroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

final class MatubupMergerVisiMatubuparch extends InfoMergerVisitorTemplate<MatubupInfo, MatubuparchInfo> {

	@Override public boolean shouldMerge(MatubupInfo baseInfo, MatubuparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MatubupInfo> merge(MatubupInfo baseInfo, MatubuparchInfo selectedInfo) {
		List<MatubupInfo> results = new ArrayList<>();
		
		MatubupInfo result = MatubupInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
