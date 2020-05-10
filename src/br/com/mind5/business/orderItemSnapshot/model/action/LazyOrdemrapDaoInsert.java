package br.com.mind5.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdemrapDaoInsert extends ActionLazyTemplateV2<OrdemrapInfo, OrdemrapInfo> {

	public LazyOrdemrapDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdemrapInfo> translateRecordInfosHook(List<OrdemrapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdemrapInfo> getInstanceOfActionHook(DeciTreeOption<OrdemrapInfo> option) {
		return new StdOrdemrapDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<OrdemrapInfo> translateResultHook(DeciResult<OrdemrapInfo> result) {
		return result;
	}
}