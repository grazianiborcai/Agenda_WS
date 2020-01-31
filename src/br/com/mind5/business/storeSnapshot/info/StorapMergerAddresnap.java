package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerAddresnap extends InfoMergerTemplate_<StorapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, AddresnapInfo> getVisitorHook() {
		return new StorapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
