package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.NodeMatextInsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatextNodeInsert extends ActionLazyTemplate<MatextInfo, MatextInfo> {

	public LazyMatextNodeInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextInfo> translateRecordInfosHook(List<MatextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatextInfo> getInstanceOfActionHook(DeciTreeOption<MatextInfo> option) {
		return new NodeMatextInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatextInfo> translateResultHook(DeciResult<MatextInfo> result) {
		return result;
	}
}
