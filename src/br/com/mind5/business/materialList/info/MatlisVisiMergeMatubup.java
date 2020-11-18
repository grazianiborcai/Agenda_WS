package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

final class MatlisVisiMergeMatubup extends InfoMergerVisitorTemplate<MatlisInfo, MatubupInfo> {
	
	@Override public List<MatlisInfo> beforeMerge(List<MatlisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatubupInfo selectedInfo) {
		return (baseInfo.codSubgroup == selectedInfo.codSubgroup);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatubupInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtSubgroup = selectedInfo.txtSubgroup;
		baseInfo.sortSubgroup = selectedInfo.sortSubgroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatlisInfo> getUniquifier() {
		return null;
	}
}
