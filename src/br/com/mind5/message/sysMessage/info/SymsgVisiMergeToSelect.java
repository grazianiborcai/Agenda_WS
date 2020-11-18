package br.com.mind5.message.sysMessage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SymsgVisiMergeToSelect extends InfoMergerVisitorTemplate<SymsgInfo, SymsgInfo> {
	
	@Override public List<SymsgInfo> beforeMerge(List<SymsgInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SymsgInfo baseInfo, SymsgInfo selectedInfo) {
		return (baseInfo.codMsg == selectedInfo.codMsg &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SymsgInfo> merge(SymsgInfo baseInfo, SymsgInfo selectedInfo) {
		List<SymsgInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguageBase = baseInfo.codLanguageBase;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SymsgInfo> getUniquifier() {
		return null;
	}
}
