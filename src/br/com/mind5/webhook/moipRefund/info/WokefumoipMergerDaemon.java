package br.com.mind5.webhook.moipRefund.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class WokefumoipMergerDaemon extends InfoMergerTemplate_<WokefumoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<WokefumoipInfo, UserInfo> getVisitorHook() {
		return new WokefumoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokefumoipInfo> getUniquifierHook() {
		return new WokefumoipUniquifier();
	}
}
