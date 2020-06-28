package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.NodeCompInsert;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCompNodeInsert extends ActionLazyTemplateV2<CompInfo, CompInfo> {
	
	public LazyCompNodeInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CompInfo> translateRecordInfosHook(List<CompInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CompInfo> getInstanceOfActionHook(DeciTreeOption<CompInfo> option) {
		return new NodeCompInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CompInfo> translateResultHook(DeciResult<CompInfo> result) {
		return result;
	}
}
