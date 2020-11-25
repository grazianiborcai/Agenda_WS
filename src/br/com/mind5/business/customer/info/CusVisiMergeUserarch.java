package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userSearch.info.UserarchInfo;

final class CusVisiMergeUserarch extends InfoMergerVisitorTemplate<CusInfo, UserarchInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, UserarchInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
