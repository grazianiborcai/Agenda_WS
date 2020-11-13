package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceNameSearch;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeToSelect;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeMerge;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceNameKey;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckLangu;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckOwner;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadName;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStorbySelectName extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public RootStorbySelectName(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> enforceNameKey = new StdStorbyEnforceNameKey(option);
		ActionLazy<StorbyInfo> enforceNameSearch = new LazyStorbyEnforceNameSearch(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> select = new LazyStorbyMergeToSelect(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> nodeMerge = new LazyStorbyNodeMerge(option.conn, option.schemaName);
		
		enforceNameKey.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(select);
		select.addPostAction(nodeMerge);
		
		actions.add(enforceNameKey);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
