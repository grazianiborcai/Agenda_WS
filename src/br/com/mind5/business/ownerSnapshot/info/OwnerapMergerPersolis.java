package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class OwnerapMergerPersolis extends InfoMergerTemplate<OwnerapInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, PersolisInfo> getVisitorHook() {
		return new OwnerapVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
