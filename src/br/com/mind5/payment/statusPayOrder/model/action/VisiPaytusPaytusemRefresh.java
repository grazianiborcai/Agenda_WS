package br.com.mind5.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.decisionTree.RootPaytusemRefresh;

final class VisiPaytusPaytusemRefresh extends ActionVisitorTemplateAction<PaytusInfo, PaytusemInfo> {
	
	public VisiPaytusPaytusemRefresh(Connection conn, String schemaName) {
		super(conn, schemaName, PaytusInfo.class, PaytusemInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaytusemInfo> getActionHook(DeciTreeOption<PaytusemInfo> option) {
		return new RootPaytusemRefresh(option).toAction();
	}
	
	

	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PaytusemInfo> results) {	
		return PaytusMerger.mergeWithPaytusem(results, baseInfos);
	}
}
