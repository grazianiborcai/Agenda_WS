package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapVisiMergePersolis implements InfoMergerVisitor<UserapInfo, PersolisInfo> {
	
	@Override public List<UserapInfo> beforeMerge(List<UserapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserapInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner 	&& 
				baseInfo.codPerson == selectedInfo.codPerson		);
	}
	
	

	@Override public List<UserapInfo> merge(UserapInfo baseInfo, PersolisInfo selectedInfo) {
		List<UserapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserapInfo> getUniquifier() {
		return new UserapUniquifier();
	}
}
