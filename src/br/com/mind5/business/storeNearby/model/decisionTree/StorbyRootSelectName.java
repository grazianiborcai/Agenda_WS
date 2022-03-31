package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiNodeMerge;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceNameKey;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceNameSearch;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeToSelect;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckLangu;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckOwner;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadName;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyRootSelectName extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyRootSelectName(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelChecker<StorbyInfo>> queue = new ArrayList<>();		
		ModelChecker<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorbyCheckReadName(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorbyCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorbyCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> enforceNameKey = new ActionStdCommom<StorbyInfo>(option, StorbyVisiEnforceNameKey.class);
		ActionLazy<StorbyInfo> enforceNameSearch = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiEnforceNameSearch.class);
		ActionLazy<StorbyInfo> select = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeToSelect.class);
		ActionLazy<StorbyInfo> nodeMerge = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiNodeMerge.class);
		
		enforceNameKey.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(select);
		select.addPostAction(nodeMerge);
		
		actions.add(enforceNameKey);			
		return actions;
	}
}
