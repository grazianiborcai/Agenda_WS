package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatVisiMergeUsername extends InfoMergerVisitorTemplate<MatInfo, UsernameInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, UsernameInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
