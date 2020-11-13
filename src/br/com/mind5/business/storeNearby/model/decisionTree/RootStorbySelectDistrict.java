package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistrictSearch;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeToSelect;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeMerge;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceDistrictKey;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckLangu;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckOwner;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadDistrict;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStorbySelectDistrict extends DeciTreeTemplateRead<StorbyInfo> {
	
	public RootStorbySelectDistrict(DeciTreeOption<StorbyInfo> option) {
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
		checker = new StorbyCheckReadDistrict(checkerOption);
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
		
		ActionStd<StorbyInfo> enforceDistrictKey = new StdStorbyEnforceDistrictKey(option);
		ActionLazy<StorbyInfo> enforceDistrictSearch = new LazyStorbyEnforceDistrictSearch(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> select = new LazyStorbyMergeToSelect(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> nodeMerge = new LazyStorbyNodeMerge(option.conn, option.schemaName);
		
		enforceDistrictKey.addPostAction(enforceDistrictSearch);
		enforceDistrictSearch.addPostAction(select);
		select.addPostAction(nodeMerge);
		
		actions.add(enforceDistrictKey);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
