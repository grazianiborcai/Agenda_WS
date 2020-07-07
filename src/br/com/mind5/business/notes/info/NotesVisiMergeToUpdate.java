package br.com.mind5.business.notes.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class NotesVisiMergeToUpdate implements InfoMergerVisitorV3<NotesInfo, NotesInfo> {
	
	@Override public List<NotesInfo> beforeMerge(List<NotesInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codNote  == selectedInfo.codNote		);
	}
	
	
	
	@Override public List<NotesInfo> merge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		List<NotesInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<NotesInfo> getUniquifier() {
		return null;
	}
}
