package br.com.mind5.payment.partnerMoip.accessMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AccemoipMergerSysEnviron extends InfoMergerTemplate<AccemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<AccemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new AccemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
