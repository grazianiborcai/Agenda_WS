package br.com.mind5.business.personListRestricted.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class PersoresMergerPersolis extends InfoMergerTemplate<PersoresInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor<PersoresInfo, PersolisInfo> getVisitorHook() {
		return new PersoresVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<PersoresInfo> getUniquifierHook() {
		return new PersoresUniquifier();
	}
}
