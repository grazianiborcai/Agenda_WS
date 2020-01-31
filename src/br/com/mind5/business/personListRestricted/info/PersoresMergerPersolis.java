package br.com.mind5.business.personListRestricted.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class PersoresMergerPersolis extends InfoMergerTemplate_<PersoresInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor_<PersoresInfo, PersolisInfo> getVisitorHook() {
		return new PersoresVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<PersoresInfo> getUniquifierHook() {
		return new PersoresUniquifier();
	}
}
