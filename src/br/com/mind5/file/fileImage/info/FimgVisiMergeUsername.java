package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class FimgVisiMergeUsername extends InfoMergerVisitorTemplate<FimgInfo, UsernameInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, UsernameInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
