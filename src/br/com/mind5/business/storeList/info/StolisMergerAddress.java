package br.com.mind5.business.storeList.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerAddress extends InfoMergerTemplate_<StolisInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, AddressInfo> getVisitorHook() {
		return new StolisVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
