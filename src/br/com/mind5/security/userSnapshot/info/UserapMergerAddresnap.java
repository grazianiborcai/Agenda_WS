package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerAddresnap extends InfoMergerTemplate<UserapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, AddresnapInfo> getVisitorHook() {
		return new UserapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
