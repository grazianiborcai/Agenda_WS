package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeStowotarch;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmRootDelete;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmEnforceStoreKey;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDeleteByStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStowotmDeleteByStore extends DeciTreeWriteTemplate<StowotmInfo> {
	
	public RootStowotmDeleteByStore(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildDecisionCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckDeleteByStore(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<StowotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceStoreKey = new StdStowotmEnforceStoreKey(option);
		ActionLazy<StowotmInfo> mergeStowotarch = new LazyStowotmMergeStowotarch(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> delete = new LazyStowotmRootDelete(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(mergeStowotarch);
		mergeStowotarch.addPostAction(delete);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
