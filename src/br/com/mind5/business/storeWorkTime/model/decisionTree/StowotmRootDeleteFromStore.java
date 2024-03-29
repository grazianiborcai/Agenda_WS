package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeStowotarchStore;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiRootDelete;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDeleteFromStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StowotmRootDeleteFromStore extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public StowotmRootDeleteFromStore(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckDeleteFromStore(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<StowotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> mergeStowotarch = new ActionStdCommom<StowotmInfo>(option, StowotmVisiMergeStowotarchStore.class);
		ActionLazy<StowotmInfo> delete = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiRootDelete.class);
		
		mergeStowotarch.addPostAction(delete);
		
		actions.add(mergeStowotarch);
		return actions;
	}
}
