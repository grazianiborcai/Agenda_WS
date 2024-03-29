package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatmovMergerVisiUsername extends InfoMergerVisitorTemplate<MatmovInfo, UsernameInfo> {

	@Override public boolean shouldMerge(MatmovInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, UsernameInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
