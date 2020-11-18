package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

final class MatVisiMergeMatubup extends InfoMergerVisitorTemplate<MatInfo, MatubupInfo> {
	
	@Override public List<MatInfo> beforeMerge(List<MatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatInfo baseInfo, MatubupInfo selectedInfo) {
		return (baseInfo.codSubgroup == selectedInfo.codSubgroup);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatubupInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtSubgroup = selectedInfo.txtSubgroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatInfo> getUniquifier() {
		return null;
	}
}
