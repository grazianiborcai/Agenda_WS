package br.com.mind5.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderemMergeUsername extends ActionLazyTemplateV2<OrderemInfo, OrderemInfo> {

	public LazyOrderemMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderemInfo> translateRecordInfosHook(List<OrderemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrderemInfo> getInstanceOfActionHook(DeciTreeOption<OrderemInfo> option) {
		return new StdOrderemMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<OrderemInfo> translateResultHook(DeciResult<OrderemInfo> result) {
		return result;
	}
}
