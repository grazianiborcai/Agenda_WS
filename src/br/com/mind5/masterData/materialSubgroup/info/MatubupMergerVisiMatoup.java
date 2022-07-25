package br.com.mind5.masterData.materialSubgroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatubupMergerVisiMatoup extends InfoMergerVisitorTemplate<MatubupInfo, MatoupInfo> {

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
}
