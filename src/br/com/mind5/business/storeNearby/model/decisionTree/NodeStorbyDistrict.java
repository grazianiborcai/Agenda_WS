package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeToSelect;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyPruneEmpty;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceDistrictKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeStorbyDistrict extends DeciTreeTemplateRead<StorbyInfo> {
	
	public NodeStorbyDistrict(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelChecker<StorbyInfo>> queue = new ArrayList<>();		
		ModelChecker<StorbyInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> enforceDistrictKey = new StdStorbyEnforceDistrictKey(option);
		ActionLazy<StorbyInfo> select = new LazyStorbyMergeToSelect(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> pruneEmpty = new LazyStorbyPruneEmpty(option.conn, option.schemaName);
		
		enforceDistrictKey.addPostAction(select);
		select.addPostAction(pruneEmpty);
		
		actions.add(enforceDistrictKey);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
