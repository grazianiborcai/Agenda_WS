package br.com.gda.webhook.moipRefund.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class WokefumoipMergerDaemon extends InfoMergerTemplate<WokefumoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor<WokefumoipInfo, UserInfo> getVisitorHook() {
		return new WokefumoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokefumoipInfo> getUniquifierHook() {
		return new WokefumoipUniquifier();
	}
}
