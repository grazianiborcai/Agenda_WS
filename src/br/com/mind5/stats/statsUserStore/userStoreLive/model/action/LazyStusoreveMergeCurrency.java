package br.com.mind5.stats.statsUserStore.userStoreLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

public final class LazyStusoreveMergeCurrency extends ActionLazyTemplate<StusoreveInfo, StusoreveInfo> {

	public LazyStusoreveMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StusoreveInfo> translateRecordInfosHook(List<StusoreveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StusoreveInfo> getInstanceOfActionHook(DeciTreeOption<StusoreveInfo> option) {
		return new StdStusoreveMergeCurrency(option);
	}
	
	
	
	@Override protected DeciResult<StusoreveInfo> translateResultHook(DeciResult<StusoreveInfo> result) {
		return result;
	}
}
