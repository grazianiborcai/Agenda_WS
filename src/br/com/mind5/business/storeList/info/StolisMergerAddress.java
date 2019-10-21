package br.com.mind5.business.storeList.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerAddress extends InfoMergerTemplate<StolisInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, AddressInfo> getVisitorHook() {
		return new StolisVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
