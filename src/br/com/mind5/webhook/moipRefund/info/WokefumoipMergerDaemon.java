package br.com.mind5.webhook.moipRefund.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class WokefumoipMergerDaemon extends InfoMergerTemplate<WokefumoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor<WokefumoipInfo, UserInfo> getVisitorHook() {
		return new WokefumoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokefumoipInfo> getUniquifierHook() {
		return new WokefumoipUniquifier();
	}
}
