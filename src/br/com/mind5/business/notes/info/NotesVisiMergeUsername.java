package br.com.mind5.business.notes.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class NotesVisiMergeUsername implements InfoMergerVisitorV3<NotesInfo, UsernameInfo> {
	
	@Override public List<NotesInfo> beforeMerge(List<NotesInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(NotesInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<NotesInfo> merge(NotesInfo baseInfo, UsernameInfo selectedInfo) {
		List<NotesInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<NotesInfo> getUniquifier() {
		return null;
	}
}
