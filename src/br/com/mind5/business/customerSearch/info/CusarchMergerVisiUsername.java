package br.com.mind5.business.customerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class CusarchMergerVisiUsername extends InfoMergerVisitorTemplate<CusarchInfo, UsernameInfo> {

	@Override public boolean shouldMerge(CusarchInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<CusarchInfo> merge(CusarchInfo baseInfo, UsernameInfo selectedInfo) {
		List<CusarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
