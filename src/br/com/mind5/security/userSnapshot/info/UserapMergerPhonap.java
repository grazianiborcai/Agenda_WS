package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserapMergerPhonap extends InfoMergerTemplate_<UserapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor_<UserapInfo, PhonapInfo> getVisitorHook() {
		return new UserapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
