package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiNodeMerge;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeAddress;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeComplis;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeToSelect;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiPruneDistance50;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckRead50km;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyRootSelect50km extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyRootSelect50km(DeciTreeOption<StorbyInfo> option) {
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
		checker = new StorbyCheckRead50km(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> select = new ActionStdCommom<StorbyInfo>(option, StorbyVisiMergeToSelect.class);		
		ActionLazy<StorbyInfo> mergeComplis = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeComplis.class);
		ActionLazy<StorbyInfo> mergeAddress = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeAddress.class);
		ActionLazy<StorbyInfo> enforceDistance = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiEnforceDistance.class);
		ActionLazy<StorbyInfo> pruneDistance50 = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiPruneDistance50.class);
		ActionLazy<StorbyInfo> nodeMerge = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiNodeMerge.class);
		
		select.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(pruneDistance50);
		pruneDistance50.addPostAction(nodeMerge);
		
		actions.add(select);			
		return actions;
	}
}
