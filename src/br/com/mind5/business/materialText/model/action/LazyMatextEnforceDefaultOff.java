package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatextEnforceDefaultOff extends ActionLazyTemplate<MatextInfo, MatextInfo> {
	
	public LazyMatextEnforceDefaultOff(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatextInfo> translateRecordInfosHook(List<MatextInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatextInfo> getInstanceOfActionHook(DeciTreeOption<MatextInfo> option) {
		return new StdMatextEnforceDefaultOff(option);
	}
	
	
	
	@Override protected DeciResult<MatextInfo> translateResultHook(DeciResult<MatextInfo> result) {
		return result;
	}
}
