package br.com.mind5.business.notes.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class NotesVisiMergeToSelect extends InfoMergerVisitorTemplate<NotesInfo, NotesInfo> {
	
	@Override public List<NotesInfo> beforeMerge(List<NotesInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<NotesInfo> merge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		List<NotesInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<NotesInfo> getUniquifier() {
		return null;
	}
}
