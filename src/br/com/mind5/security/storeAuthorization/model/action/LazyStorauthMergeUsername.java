package br.com.mind5.security.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class LazyStorauthMergeUsername extends ActionLazyTemplate<StorauthInfo, StorauthInfo> {
	
	public LazyStorauthMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorauthInfo> translateRecordInfosHook(List<StorauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StorauthInfo> getInstanceOfActionHook(DeciTreeOption<StorauthInfo> option) {
		return new StdStorauthMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<StorauthInfo> translateResultHook(DeciResult<StorauthInfo> result) {
		return result;
	}
}
