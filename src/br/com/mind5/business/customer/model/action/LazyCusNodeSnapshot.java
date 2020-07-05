package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.NodeCusSnapshot;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCusNodeSnapshot extends ActionLazyTemplateV2<CusInfo, CusInfo> {
	
	public LazyCusNodeSnapshot(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusInfo> translateRecordInfosHook(List<CusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CusInfo> getInstanceOfActionHook(DeciTreeOption<CusInfo> option) {
		return new NodeCusSnapshot(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusInfo> translateResultHook(DeciResult<CusInfo> result) {
		return result;
	}
}
