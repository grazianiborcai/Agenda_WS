package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.decisionTree.NodeMatextInsert;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatextNodeInsert extends ActionLazyTemplate<MatextInfo, MatextInfo> {

	public LazyMatextNodeInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextInfo> translateRecordInfosHook(List<MatextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getInstanceOfActionHook(DeciTreeOption<MatextInfo> option) {
		return new NodeMatextInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatextInfo> translateResultHook(DeciResult<MatextInfo> result) {
		return result;
	}
}
