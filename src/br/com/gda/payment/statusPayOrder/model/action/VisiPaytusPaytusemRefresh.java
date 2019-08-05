package br.com.gda.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.info.PaytusMerger;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.gda.payment.statusPayOrderItem.model.decisionTree.RootPaytusemRefresh;

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
