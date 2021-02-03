package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatoreVisiMergeUsername extends InfoMergerVisitorTemplate<MatoreInfo, UsernameInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, UsernameInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
