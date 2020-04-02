package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmMergeStowotarch;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootStowotmSearch extends DeciTreeReadTemplate<StowotmInfo> {
	
	public RootStowotmSearch(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildDecisionCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;

		checker = new StowotmCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> mergeStowotarch = new StdStowotmMergeStowotarch(option);
		ActionLazyV1<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		mergeStowotarch.addPostAction(select);
		
		actions.add(mergeStowotarch);		
		return actions; 
	}
}
