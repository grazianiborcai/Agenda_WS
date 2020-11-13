package br.com.mind5.message.emailWelcome.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmacomeMergeUselis extends ActionLazyTemplate<EmacomeInfo, EmacomeInfo> {

	public LazyEmacomeMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmacomeInfo> translateRecordInfosHook(List<EmacomeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmacomeInfo> getInstanceOfActionHook(DeciTreeOption<EmacomeInfo> option) {
		return new StdEmacomeMergeUselis(option);
	}
	
	
	
	@Override protected DeciResult<EmacomeInfo> translateResultHook(DeciResult<EmacomeInfo> result) {
		return result;
	}
}
