package br.com.gda.payment.customerPartner.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerAddress extends InfoMergerTemplate<CusparInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, AddressInfo> getVisitorHook() {
		return new CusparVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
