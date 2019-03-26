package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.decisionTree.NodeMatextHasDefault;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatextNodeHasDefault extends ActionLazyTemplate<MatextInfo, MatextInfo> {

	public LazyMatextNodeHasDefault(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextInfo> translateRecordInfosHook(List<MatextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getInstanceOfActionHook(DeciTreeOption<MatextInfo> option) {
		return new NodeMatextHasDefault(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatextInfo> translateResultHook(DeciResult<MatextInfo> result) {
		return result;
	}
}
