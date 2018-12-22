package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatSnapSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatSnapRootSelect extends ActionLazyTemplate<MatSnapInfo, MatSnapInfo> {
	
	public LazyMatSnapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatSnapInfo> translateRecordInfosHook(List<MatSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatSnapInfo> getInstanceOfActionHook(DeciTreeOption<MatSnapInfo> option) {
		return new RootMatSnapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatSnapInfo> translateResultHook(DeciResult<MatSnapInfo> result) {
		return result;
	}
}
