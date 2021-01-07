package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeAddress;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeComplis;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeMerge;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyPruneDistance50;
import br.com.mind5.business.storeNearby.model.action.StdStorbyMergeToSelect;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckRead50km;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStorbySelect50km extends DeciTreeTemplateRead<StorbyInfo> {
	
	public RootStorbySelect50km(DeciTreeOption<StorbyInfo> option) {
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
		
		ActionStd<StorbyInfo> select = new StdStorbyMergeToSelect(option);		
		ActionLazy<StorbyInfo> mergeComplis = new LazyStorbyMergeComplis(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> mergeAddress = new LazyStorbyMergeAddress(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> enforceDistance = new LazyStorbyEnforceDistance(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> pruneDistance50 = new LazyStorbyPruneDistance50(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> nodeMerge = new LazyStorbyNodeMerge(option.conn, option.schemaName);
		
		select.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(pruneDistance50);
		pruneDistance50.addPostAction(nodeMerge);
		
		actions.add(select);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
