package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusparMergerPhone extends InfoMergerTemplate<CusparInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, PhoneInfo> getVisitorHook() {
		return new CusparVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
