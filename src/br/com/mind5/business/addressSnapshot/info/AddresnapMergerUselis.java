package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class AddresnapMergerUselis extends InfoMergerTemplate_<AddresnapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor_<AddresnapInfo, UselisInfo> getVisitorHook() {
		return new AddresnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
