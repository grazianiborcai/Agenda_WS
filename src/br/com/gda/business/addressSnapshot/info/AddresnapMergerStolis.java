package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class AddresnapMergerStolis extends InfoMergerTemplate<AddresnapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, StolisInfo> getVisitorHook() {
		return new AddresnapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
