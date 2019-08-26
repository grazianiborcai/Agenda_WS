package br.com.gda.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.business.orderItemSnapshot.model.decisionTree.NodeOrdemrapStore;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrdemrapNodeStore extends ActionLazyTemplate<OrdemrapInfo, OrdemrapInfo> {
	
	public LazyOrdemrapNodeStore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdemrapInfo> translateRecordInfosHook(List<OrdemrapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdemrapInfo> getInstanceOfActionHook(DeciTreeOption<OrdemrapInfo> option) {
		return new NodeOrdemrapStore(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdemrapInfo> translateResultHook(DeciResult<OrdemrapInfo> result) {		
		return result;
	}
}
