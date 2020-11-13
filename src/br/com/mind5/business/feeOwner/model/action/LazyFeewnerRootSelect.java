package br.com.mind5.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.decisionTree.RootFeewnerSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFeewnerRootSelect extends ActionLazyTemplate<FeewnerInfo, FeewnerInfo> {

	public LazyFeewnerRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeewnerInfo> translateRecordInfosHook(List<FeewnerInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FeewnerInfo> getInstanceOfActionHook(DeciTreeOption<FeewnerInfo> option) {
		return new RootFeewnerSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FeewnerInfo> translateResultHook(DeciResult<FeewnerInfo> result) {
		return result;
	}
}
