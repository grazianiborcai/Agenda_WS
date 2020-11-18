package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

final class MatsnapVisiMergeMatubup extends InfoMergerVisitorTemplate<MatsnapInfo, MatubupInfo> {
	
	@Override public List<MatsnapInfo> beforeMerge(List<MatsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatubupInfo selectedInfo) {
		return (baseInfo.codSubgroup == selectedInfo.codSubgroup);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatubupInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtSubgroup = selectedInfo.txtSubgroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatsnapInfo> getUniquifier() {
		return null;
	}
}
