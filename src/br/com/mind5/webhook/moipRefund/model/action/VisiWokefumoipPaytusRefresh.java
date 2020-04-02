package br.com.mind5.webhook.moipRefund.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefreshAuth;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

final class VisiWokefumoipPaytusRefresh extends ActionVisitorTemplateAction<WokefumoipInfo, PaytusInfo> {
	public VisiWokefumoipPaytusRefresh(Connection conn, String schemaName) {
		super(conn, schemaName, WokefumoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PaytusInfo> getActionHook(DeciTreeOption<PaytusInfo> option) {
		return new RootPaytusRefreshAuth(option).toAction();
	}
	
	
	
	@Override protected List<WokefumoipInfo> toBaseClassHook(List<WokefumoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
