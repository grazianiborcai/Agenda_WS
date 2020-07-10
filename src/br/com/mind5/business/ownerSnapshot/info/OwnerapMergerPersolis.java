package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class OwnerapMergerPersolis extends InfoMergerTemplate_<OwnerapInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor_<OwnerapInfo, PersolisInfo> getVisitorHook() {
		return new OwnerapVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
