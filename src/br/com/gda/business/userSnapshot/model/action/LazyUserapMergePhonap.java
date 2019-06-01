package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyUserapMergePhonap extends ActionLazyTemplate<UserapInfo, UserapInfo> {
	
	public LazyUserapMergePhonap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserapInfo> translateRecordInfosHook(List<UserapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserapInfo> getInstanceOfActionHook(DeciTreeOption<UserapInfo> option) {
		return new StdUserapMergePhonap(option);
	}
	
	
	
	@Override protected DeciResult<UserapInfo> translateResultHook(DeciResult<UserapInfo> result) {
		return result;
	}
}
