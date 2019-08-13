package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorapMergerAddresnap extends InfoMergerTemplate<StorapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, AddresnapInfo> getVisitorHook() {
		return new StorapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
