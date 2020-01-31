package br.com.mind5.payment.partnerMoip.accessMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AccemoipMergerSysEnviron extends InfoMergerTemplate_<AccemoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<AccemoipInfo, SysEnvironInfo> getVisitorHook() {
		return new AccemoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
