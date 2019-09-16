package br.com.gda.business.ownerSnapshot.info;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class OwnerapMergerPersolis extends InfoMergerTemplate<OwnerapInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, PersolisInfo> getVisitorHook() {
		return new OwnerapVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
