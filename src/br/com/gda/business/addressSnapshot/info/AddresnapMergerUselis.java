package br.com.gda.business.addressSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userList.info.UselisInfo;

public final class AddresnapMergerUselis extends InfoMergerTemplate<AddresnapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, UselisInfo> getVisitorHook() {
		return new AddresnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
