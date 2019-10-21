package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerPhonap extends InfoMergerTemplate<UserapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, PhonapInfo> getVisitorHook() {
		return new UserapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
