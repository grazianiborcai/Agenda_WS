package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmpMergerVisiUselis extends InfoMergerVisitorTemplate<EmpInfo, UselisInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, UselisInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo.fimistData;	
		
		results.add(baseInfo);
		return results;
	}
}
