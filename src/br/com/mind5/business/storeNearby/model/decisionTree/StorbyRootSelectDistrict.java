package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiNodeMerge;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceDistrictKey;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceDistrictSearch;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeToSelect;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckLangu;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckOwner;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadDistrict;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyRootSelectDistrict extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyRootSelectDistrict(DeciTreeOption<StorbyInfo> option) {
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
		
		ActionStd<StorbyInfo> enforceDistrictKey = new ActionStdCommom<StorbyInfo>(option, StorbyVisiEnforceDistrictKey.class);
		ActionLazy<StorbyInfo> enforceDistrictSearch = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiEnforceDistrictSearch.class);
		ActionLazy<StorbyInfo> select = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeToSelect.class);
		ActionLazy<StorbyInfo> nodeMerge = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiNodeMerge.class);
		
		enforceDistrictKey.addPostAction(enforceDistrictSearch);
		enforceDistrictSearch.addPostAction(select);
		select.addPostAction(nodeMerge);
		
		actions.add(enforceDistrictKey);			
		return actions;
	}
}
