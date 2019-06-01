package br.com.gda.business.userSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerToSelect extends InfoMergerTemplate<UserapInfo, UserapInfo> {

	@Override protected InfoMergerVisitorV2<UserapInfo, UserapInfo> getVisitorHook() {
		return new UserapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
