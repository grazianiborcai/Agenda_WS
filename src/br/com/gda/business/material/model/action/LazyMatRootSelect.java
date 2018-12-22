package br.com.gda.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatRootSelect extends ActionLazyTemplate<MatInfo, MatInfo> {
	
	public LazyMatRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatInfo> translateRecordInfosHook(List<MatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatInfo> getInstanceOfActionHook(DeciTreeOption<MatInfo> option) {
		return new RootMatSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatInfo> translateResultHook(DeciResult<MatInfo> result) {
		return result;
	}
}
