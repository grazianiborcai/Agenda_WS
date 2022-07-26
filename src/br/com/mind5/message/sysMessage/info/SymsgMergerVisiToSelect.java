package br.com.mind5.message.sysMessage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SymsgMergerVisiToSelect extends InfoMergerVisitorTemplate<SymsgInfo, SymsgInfo> {

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
}
