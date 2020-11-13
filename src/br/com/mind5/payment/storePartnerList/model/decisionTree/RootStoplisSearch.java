package br.com.mind5.payment.storePartnerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.action.LazyStoplisRootSelect;
import br.com.mind5.payment.storePartnerList.model.action.StdStoplisMergeStoparch;

public final class RootStoplisSearch extends DeciTreeTemplateReadV2<StoplisInfo> {
	
	public RootStoplisSearch(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoplisInfo> buildCheckerHook(DeciTreeOption<StoplisInfo> option) {
		List<ModelCheckerV1<StoplisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoplisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoplisInfo>> buildActionsOnPassedHook(DeciTreeOption<StoplisInfo> option) {
		List<ActionStdV1<StoplisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoplisInfo> mergeStoparch = new StdStoplisMergeStoparch(option);
		ActionLazy<StoplisInfo> select = new LazyStoplisRootSelect(option.conn, option.schemaName);
		
		mergeStoparch.addPostAction(select);
		
		actions.add(mergeStoparch);
		return actions;
	}
}
