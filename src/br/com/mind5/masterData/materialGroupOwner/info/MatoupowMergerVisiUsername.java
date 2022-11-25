package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatoupowMergerVisiUsername extends InfoMergerVisitorTemplate<MatoupowInfo, UsernameInfo> {

	@Override public boolean shouldMerge(MatoupowInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<MatoupowInfo> merge(MatoupowInfo baseInfo, UsernameInfo selectedInfo) {
		List<MatoupowInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
