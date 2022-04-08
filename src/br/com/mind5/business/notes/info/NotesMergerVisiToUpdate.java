package br.com.mind5.business.notes.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class NotesMergerVisiToUpdate extends InfoMergerVisitorTemplate<NotesInfo, NotesInfo> {

	@Override public boolean shouldMerge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codNote  == selectedInfo.codNote		);
	}
	
	
	
	@Override public List<NotesInfo> merge(NotesInfo baseInfo, NotesInfo selectedInfo) {
		List<NotesInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
