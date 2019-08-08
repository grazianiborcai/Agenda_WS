package br.com.gda.payment.customerPartner.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerAddresnap extends InfoMergerTemplate<CusparInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, AddresnapInfo> getVisitorHook() {
		return new CusparVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
