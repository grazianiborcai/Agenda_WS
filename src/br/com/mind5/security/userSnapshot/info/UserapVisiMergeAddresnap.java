package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserapVisiMergeAddresnap extends InfoMergerVisitorTemplate<UserapInfo, AddresnapInfo> {

	@Override public boolean shouldMerge(UserapInfo baseInfo, AddresnapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 		&& 
				baseInfo.codUser	 == selectedInfo.codUser  		&&
				baseInfo.codSnapshot == selectedInfo.codUserSnapshot	);
	}
	
	

	@Override public List<UserapInfo> merge(UserapInfo baseInfo, AddresnapInfo selectedInfo) {
		List<UserapInfo> results = new ArrayList<>();
		
		baseInfo.addresses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<UserapInfo> uniquifyHook(List<UserapInfo> results) {
		InfoUniquifier<UserapInfo> uniquifier = new UserapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
