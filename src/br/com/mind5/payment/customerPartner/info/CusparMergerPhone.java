package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusparMergerPhone extends InfoMergerTemplate_<CusparInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, PhoneInfo> getVisitorHook() {
		return new CusparVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
