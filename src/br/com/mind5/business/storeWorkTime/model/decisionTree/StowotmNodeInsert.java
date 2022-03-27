package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiDaoInsert;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiDaoUpdate;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceCreatedBy;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceCreatedOn;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceLChanged;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeUsername;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiNodeSnapshot;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiRootSelect;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

final class StowotmNodeInsert extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public StowotmNodeInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StowotmCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new ActionStdCommom<StowotmInfo>(option, StowotmVisiEnforceLChanged.class);
		ActionLazy<StowotmInfo> enforceLChangedBy = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiMergeUsername.class);
		ActionLazy<StowotmInfo> enforceCreatedOn = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceCreatedOn.class);
		ActionLazy<StowotmInfo> enforceCreatedBy = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceCreatedBy.class);
		ActionLazy<StowotmInfo> insert = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiDaoInsert.class);
		ActionLazy<StowotmInfo> snapshot = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiNodeSnapshot.class);
		ActionLazy<StowotmInfo> select = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnFailedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new ActionStdCommom<StowotmInfo>(option, StowotmVisiEnforceLChanged.class);
		ActionLazy<StowotmInfo> enforceLChangedBy = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiMergeUsername.class);
		ActionLazy<StowotmInfo> enforceCreatedOn = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceCreatedOn.class);
		ActionLazy<StowotmInfo> enforceCreatedBy = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceCreatedBy.class);
		ActionLazy<StowotmInfo> update = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiDaoUpdate.class);
		ActionLazy<StowotmInfo> snapshot = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiNodeSnapshot.class);
		ActionLazy<StowotmInfo> select = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
