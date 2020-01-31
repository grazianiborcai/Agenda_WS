package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserapMergerAddresnap extends InfoMergerTemplate_<UserapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<UserapInfo, AddresnapInfo> getVisitorHook() {
		return new UserapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
