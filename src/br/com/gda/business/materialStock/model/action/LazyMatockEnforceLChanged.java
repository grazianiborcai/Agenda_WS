package br.com.gda.business.materialStock.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatockEnforceLChanged extends ActionLazyTemplate<MatockInfo, MatockInfo> {
	
	public LazyMatockEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatockInfo> translateRecordInfosHook(List<MatockInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatockInfo> getInstanceOfActionHook(DeciTreeOption<MatockInfo> option) {
		return new StdMatockEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<MatockInfo> translateResultHook(DeciResult<MatockInfo> result) {
		return result;
	}
}
