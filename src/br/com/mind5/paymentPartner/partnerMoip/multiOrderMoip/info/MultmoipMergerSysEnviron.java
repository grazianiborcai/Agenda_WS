package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MultmoipMergerSysEnviron extends InfoMergerTemplate_<MultmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<MultmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new MultmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
