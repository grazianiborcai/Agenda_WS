package br.com.mind5.payment.storePartnerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.action.LazyStoplisRootSelect;
import br.com.mind5.payment.storePartnerList.model.action.StdStoplisMergeStoparch;
import br.com.mind5.payment.storePartnerList.model.checker.StoplisCheckDummy;

public final class RootStoplisSearch extends DeciTreeReadTemplate<StoplisInfo> {
	
	public RootStoplisSearch(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoplisInfo> buildDecisionCheckerHook(DeciTreeOption<StoplisInfo> option) {
		List<ModelChecker<StoplisInfo>> queue = new ArrayList<>();		
		ModelChecker<StoplisInfo> checker;

		checker = new StoplisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoplisInfo>> buildActionsOnPassedHook(DeciTreeOption<StoplisInfo> option) {
		List<ActionStdV1<StoplisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoplisInfo> mergeStoparch = new StdStoplisMergeStoparch(option);
		ActionLazyV1<StoplisInfo> select = new LazyStoplisRootSelect(option.conn, option.schemaName);
		
		mergeStoparch.addPostAction(select);
		
		actions.add(mergeStoparch);
		return actions;
	}
}
