package br.com.gda.business.address.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class AddressMergerUsername extends InfoMergerTemplate<AddressInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, UsernameInfo> getVisitorHook() {
		return new AddressVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
