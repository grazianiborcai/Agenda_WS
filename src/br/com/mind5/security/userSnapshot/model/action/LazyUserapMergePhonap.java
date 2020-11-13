package br.com.mind5.security.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class LazyUserapMergePhonap extends ActionLazyTemplate<UserapInfo, UserapInfo> {
	
	public LazyUserapMergePhonap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserapInfo> translateRecordInfosHook(List<UserapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UserapInfo> getInstanceOfActionHook(DeciTreeOption<UserapInfo> option) {
		return new StdUserapMergePhonap(option);
	}
	
	
	
	@Override protected DeciResult<UserapInfo> translateResultHook(DeciResult<UserapInfo> result) {
		return result;
	}
}
