package br.com.mind5.business.customer.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerAddress extends InfoMergerTemplate<CusInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<CusInfo, AddressInfo> getVisitorHook() {
		return new CusVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
