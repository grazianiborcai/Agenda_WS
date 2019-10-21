package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MultmoipMergerSysEnviron extends InfoMergerTemplate<MultmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new MultmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
