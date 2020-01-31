package br.com.mind5.business.customer.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerAddress extends InfoMergerTemplate_<CusInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<CusInfo, AddressInfo> getVisitorHook() {
		return new CusVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
