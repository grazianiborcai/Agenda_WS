package br.com.gda.security.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class LazyStorauthMergeOwntore extends ActionLazyTemplate<StorauthInfo, StorauthInfo> {
	
	public LazyStorauthMergeOwntore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorauthInfo> translateRecordInfosHook(List<StorauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StorauthInfo> getInstanceOfActionHook(DeciTreeOption<StorauthInfo> option) {
		return new StdStorauthMergeOwntore(option);
	}
	
	
	
	@Override protected DeciResult<StorauthInfo> translateResultHook(DeciResult<StorauthInfo> result) {
		return result;
	}
}
