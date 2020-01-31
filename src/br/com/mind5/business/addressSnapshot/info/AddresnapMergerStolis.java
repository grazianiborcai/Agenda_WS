package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class AddresnapMergerStolis extends InfoMergerTemplate_<AddresnapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor_<AddresnapInfo, StolisInfo> getVisitorHook() {
		return new AddresnapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
