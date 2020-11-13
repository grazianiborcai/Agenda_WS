package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmMergeStowotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStowotmSearch extends DeciTreeTemplateRead<StowotmInfo> {
	
	public RootStowotmSearch(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> mergeStowotarch = new StdStowotmMergeStowotarch(option);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		mergeStowotarch.addPostAction(select);
		
		actions.add(mergeStowotarch);		
		return actions; 
	}
}
