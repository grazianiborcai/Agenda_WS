package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.NodeMatoreDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatoreNodeDelete extends ActionLazyTemplate<MatoreInfo, MatoreInfo> {
	
	public LazyMatoreNodeDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatoreInfo> translateRecordInfosHook(List<MatoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<MatoreInfo> getInstanceOfActionHook(DeciTreeOption<MatoreInfo> option) {
		return new NodeMatoreDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatoreInfo> translateResultHook(DeciResult<MatoreInfo> result) {
		return result;
	}
}
