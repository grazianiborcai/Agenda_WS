package br.com.mind5.authorization.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.decisionTree.NodeStorauthSelectL1;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStorauthNodeSelectL1 extends ActionLazyTemplateV2<StorauthInfo, StorauthInfo> {
	
	public LazyStorauthNodeSelectL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorauthInfo> translateRecordInfosHook(List<StorauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorauthInfo> getInstanceOfActionHook(DeciTreeOption<StorauthInfo> option) {
		return new NodeStorauthSelectL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorauthInfo> translateResultHook(DeciResult<StorauthInfo> result) {
		return result;
	}
}
