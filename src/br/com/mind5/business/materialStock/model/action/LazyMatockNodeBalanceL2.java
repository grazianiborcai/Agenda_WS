package br.com.mind5.business.materialStock.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.decisionTree.NodeMatockBalanceL2;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatockNodeBalanceL2 extends ActionLazyTemplateV2<MatockInfo, MatockInfo> {

	public LazyMatockNodeBalanceL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatockInfo> translateRecordInfosHook(List<MatockInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatockInfo> getInstanceOfActionHook(DeciTreeOption<MatockInfo> option) {
		return new NodeMatockBalanceL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatockInfo> translateResultHook(DeciResult<MatockInfo> result) {
		return result;
	}
}
