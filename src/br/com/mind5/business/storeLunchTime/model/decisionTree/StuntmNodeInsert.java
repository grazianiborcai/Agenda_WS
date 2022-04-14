package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoInsert;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoUpdate;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceCreatedBy;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceCreatedOn;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceLChanged;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeUsername;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiNodeSnapshot;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiRootSelect;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

final class StuntmNodeInsert extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmNodeInsert(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StuntmCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> enforceLChanged = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceLChanged.class);
		ActionLazy<StuntmInfo> enforceLChangedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeUsername.class);
		ActionLazy<StuntmInfo> enforceCreatedOn = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceCreatedOn.class);
		ActionLazy<StuntmInfo> enforceCreatedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceCreatedBy.class);
		ActionLazy<StuntmInfo> insert = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoInsert.class);
		ActionLazy<StuntmInfo> snapshot = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiNodeSnapshot.class);
		ActionLazy<StuntmInfo> select = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnFailedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> enforceLChanged = new ActionStdCommom<StuntmInfo>(option, StuntmVisiEnforceLChanged.class);
		ActionLazy<StuntmInfo> enforceLChangedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeUsername.class);
		ActionLazy<StuntmInfo> enforceCreatedOn = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceCreatedOn.class);
		ActionLazy<StuntmInfo> enforceCreatedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceCreatedBy.class);
		ActionLazy<StuntmInfo> update = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoUpdate.class);
		ActionLazy<StuntmInfo> snapshot = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiNodeSnapshot.class);
		ActionLazy<StuntmInfo> select = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiRootSelect.class);
		
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
