package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusparMergerAddress extends InfoMergerTemplate<CusparInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, AddressInfo> getVisitorHook() {
		return new CusparVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
