package br.com.mind5.business.orderHistoryDecorated.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrdorycoVisiMergeUsername extends InfoMergerVisitorTemplate<OrdorycoInfo, UsernameInfo> {

	@Override public boolean shouldMerge(OrdorycoInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	

	@Override public List<OrdorycoInfo> merge(OrdorycoInfo baseInfo, UsernameInfo selectedInfo) {
		List<OrdorycoInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
