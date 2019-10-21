package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class AddresnapMergerStolis extends InfoMergerTemplate<AddresnapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, StolisInfo> getVisitorHook() {
		return new AddresnapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
