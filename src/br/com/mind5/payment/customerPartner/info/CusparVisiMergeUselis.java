package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class CusparVisiMergeUselis extends InfoMergerVisitorTemplate<CusparInfo, UselisInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codUser 	== selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, UselisInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
