package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmpVisiMergePhone extends InfoMergerVisitorTemplate<EmpInfo, PhoneInfo> {	
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner 		&&
				baseInfo.codEmployee 	== selectedInfo.codEmployee		);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, PhoneInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpInfo> getUniquifier() {
		return new EmpUniquifier();
	}
}
