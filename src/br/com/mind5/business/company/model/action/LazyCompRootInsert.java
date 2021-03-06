package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompInsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCompRootInsert extends ActionLazyTemplate<CompInfo, CompInfo> {
	
	public LazyCompRootInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CompInfo> translateRecordInfosHook(List<CompInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getInstanceOfActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CompInfo> translateResultHook(DeciResult<CompInfo> result) {
		return result;
	}
}
