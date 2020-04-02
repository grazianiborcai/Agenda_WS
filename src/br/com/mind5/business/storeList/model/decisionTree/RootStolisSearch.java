package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.LazyStolisRootSelect;
import br.com.mind5.business.storeList.model.action.StdStolisMergeSotarch;
import br.com.mind5.business.storeList.model.checker.StolisCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootStolisSearch extends DeciTreeReadTemplate<StolisInfo> {
	
	public RootStolisSearch(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolisInfo> buildDecisionCheckerHook(DeciTreeOption<StolisInfo> option) {
		List<ModelChecker<StolisInfo>> queue = new ArrayList<>();		
		ModelChecker<StolisInfo> checker;
		
		checker = new StolisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStdV1<StolisInfo>> actions = new ArrayList<>();

		ActionStdV1<StolisInfo> mergeSotarch = new StdStolisMergeSotarch(option);
		ActionLazyV1<StolisInfo> select = new LazyStolisRootSelect(option.conn, option.schemaName);
		
		mergeSotarch.addPostAction(select);
		
		actions.add(mergeSotarch);
		return actions;
	}
}
