package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpVisiMergeAddress implements InfoMergerVisitorV3<EmpInfo, AddressInfo> {
	
	@Override public List<EmpInfo> beforeMerge(List<EmpInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&&
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, AddressInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpInfo> getUniquifier() {
		return new EmpUniquifier();
	}
}
