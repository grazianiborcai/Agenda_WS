package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class OwnparMergerCounpar extends InfoMergerTemplate_<OwnparInfo, CounparInfo> {

	@Override protected InfoMergerVisitor_<OwnparInfo, CounparInfo> getVisitorHook() {
		return new OwnparVisiMergeCounpar();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
