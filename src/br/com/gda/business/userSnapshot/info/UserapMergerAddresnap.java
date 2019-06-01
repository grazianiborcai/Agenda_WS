package br.com.gda.business.userSnapshot.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerAddresnap extends InfoMergerTemplate<UserapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitorV2<UserapInfo, AddresnapInfo> getVisitorHook() {
		return new UserapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
