package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class OwnparMergerCounpar extends InfoMergerTemplate<OwnparInfo, CounparInfo> {

	@Override protected InfoMergerVisitor<OwnparInfo, CounparInfo> getVisitorHook() {
		return new OwnparVisiMergeCounpar();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
