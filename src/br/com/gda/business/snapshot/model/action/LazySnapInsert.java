package br.com.gda.business.snapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySnapInsert extends ActionLazyTemplate<SnapInfo, SnapInfo> {

	public LazySnapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SnapInfo> translateRecordInfosHook(List<SnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SnapInfo> getInstanceOfActionHook(DeciTreeOption<SnapInfo> option) {
		return new StdSnapInsert(option);
	}
	
	
	
	@Override protected DeciResult<SnapInfo> translateResultHook(DeciResult<SnapInfo> result) {
		return result;
	}
}
