package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderMergeRefupown extends ActionLazyTemplateV2<OrderInfo, OrderInfo> {

	public LazyOrderMergeRefupown(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderInfo> translateRecordInfosHook(List<OrderInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrderInfo> getInstanceOfActionHook(DeciTreeOption<OrderInfo> option) {
		return new StdOrderMergeRefupown(option);
	}
	
	
	
	@Override protected DeciResult<OrderInfo> translateResultHook(DeciResult<OrderInfo> result) {
		return result;
	}
}
