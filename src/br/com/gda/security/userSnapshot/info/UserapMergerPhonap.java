package br.com.gda.security.userSnapshot.info;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerPhonap extends InfoMergerTemplate<UserapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, PhonapInfo> getVisitorHook() {
		return new UserapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
