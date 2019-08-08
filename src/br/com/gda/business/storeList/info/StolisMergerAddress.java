package br.com.gda.business.storeList.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerAddress extends InfoMergerTemplate<StolisInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, AddressInfo> getVisitorHook() {
		return new StolisVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
