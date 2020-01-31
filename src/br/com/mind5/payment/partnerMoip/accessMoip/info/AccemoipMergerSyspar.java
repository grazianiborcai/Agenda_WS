package br.com.mind5.payment.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class AccemoipMergerSyspar extends InfoMergerTemplate_<AccemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor_<AccemoipInfo, SysparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
