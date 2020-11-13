package br.com.mind5.businessContent.material.main.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.decisionTree.NodeMatbcinInsertL2;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatbcinNodeInsertL2 extends ActionLazyTemplate<MatbcinInfo, MatbcinInfo> {

	public LazyMatbcinNodeInsertL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatbcinInfo> translateRecordInfosHook(List<MatbcinInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatbcinInfo> getInstanceOfActionHook(DeciTreeOption<MatbcinInfo> option) {
		return new NodeMatbcinInsertL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatbcinInfo> translateResultHook(DeciResult<MatbcinInfo> result) {
		return result;
	}
}
