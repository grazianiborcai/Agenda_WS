package br.com.mind5.stats.userStorePurchaseStgn.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;

public final class LazyStusorageDaoUpdate extends ActionLazyTemplate<StusorageInfo, StusorageInfo> {

	public LazyStusorageDaoUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusorageInfo> translateRecordInfosHook(List<StusorageInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusorageInfo> getInstanceOfActionHook(DeciTreeOption<StusorageInfo> option) {
		return new StdStusorageDaoUpdate(option);
	}
	
	
	
	@Override protected DeciResult<StusorageInfo> translateResultHook(DeciResult<StusorageInfo> result) {
		return result;
	}
}
