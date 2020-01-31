package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class AddressMergerUsername extends InfoMergerTemplate_<AddressInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, UsernameInfo> getVisitorHook() {
		return new AddressVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
