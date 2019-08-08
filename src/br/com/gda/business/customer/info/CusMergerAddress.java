package br.com.gda.business.customer.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerAddress extends InfoMergerTemplate<CusInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<CusInfo, AddressInfo> getVisitorHook() {
		return new CusVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
