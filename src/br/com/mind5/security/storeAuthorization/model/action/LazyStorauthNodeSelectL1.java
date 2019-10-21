package br.com.mind5.security.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.decisionTree.NodeStorauthSelectL1;

public final class LazyStorauthNodeSelectL1 extends ActionLazyTemplate<StorauthInfo, StorauthInfo> {
	
	public LazyStorauthNodeSelectL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorauthInfo> translateRecordInfosHook(List<StorauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StorauthInfo> getInstanceOfActionHook(DeciTreeOption<StorauthInfo> option) {
		return new NodeStorauthSelectL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorauthInfo> translateResultHook(DeciResult<StorauthInfo> result) {
		return result;
	}
}
