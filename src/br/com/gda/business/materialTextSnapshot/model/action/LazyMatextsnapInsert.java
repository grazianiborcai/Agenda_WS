package br.com.gda.business.materialTextSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatextsnapInsert extends ActionLazyTemplate<MatextsnapInfo, MatextsnapInfo> {
	
	public LazyMatextsnapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextsnapInfo> translateRecordInfosHook(List<MatextsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatextsnapInfo> getInstanceOfActionHook(DeciTreeOption<MatextsnapInfo> option) {
		return new StdMatextsnapInsert(option);
	}
	
	
	
	@Override protected DeciResult<MatextsnapInfo> translateResultHook(DeciResult<MatextsnapInfo> result) {
		return result;
	}
}
