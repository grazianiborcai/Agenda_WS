package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerAddresnap extends InfoMergerTemplate<StorapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, AddresnapInfo> getVisitorHook() {
		return new StorapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
