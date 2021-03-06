package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.NodeCompSnapshot;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCompNodeSnapshot extends ActionLazyTemplate<CompInfo, CompInfo> {
	
	public LazyCompNodeSnapshot(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CompInfo> translateRecordInfosHook(List<CompInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getInstanceOfActionHook(DeciTreeOption<CompInfo> option) {
		return new NodeCompSnapshot(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CompInfo> translateResultHook(DeciResult<CompInfo> result) {
		return result;
	}
}
