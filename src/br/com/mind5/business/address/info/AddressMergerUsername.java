package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class AddressMergerUsername extends InfoMergerTemplate<AddressInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, UsernameInfo> getVisitorHook() {
		return new AddressVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
