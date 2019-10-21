package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

public final class AddresnapMergerUselis extends InfoMergerTemplate<AddresnapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, UselisInfo> getVisitorHook() {
		return new AddresnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
