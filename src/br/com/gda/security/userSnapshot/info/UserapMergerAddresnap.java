package br.com.gda.security.userSnapshot.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerAddresnap extends InfoMergerTemplate<UserapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, AddresnapInfo> getVisitorHook() {
		return new UserapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
