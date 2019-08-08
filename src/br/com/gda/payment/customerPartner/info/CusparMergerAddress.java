package br.com.gda.payment.customerPartner.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerAddress extends InfoMergerTemplate<CusparInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, AddressInfo> getVisitorHook() {
		return new CusparVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
