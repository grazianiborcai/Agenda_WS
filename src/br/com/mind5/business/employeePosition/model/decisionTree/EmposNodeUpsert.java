package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.EmposVisiDaoInsert;
import br.com.mind5.business.employeePosition.model.action.EmposVisiDaoUpdate;
import br.com.mind5.business.employeePosition.model.action.EmposVisiEnforceCreatedBy;
import br.com.mind5.business.employeePosition.model.action.EmposVisiEnforceCreatedOn;
import br.com.mind5.business.employeePosition.model.action.EmposVisiEnforceLChanged;
import br.com.mind5.business.employeePosition.model.action.EmposVisiMergeUsername;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckSoftDelete;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmposNodeUpsert extends DeciTreeTemplateWrite<EmposInfo> {
	
	public EmposNodeUpsert(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmposCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new ActionStdCommom<EmposInfo>(option, EmposVisiEnforceLChanged.class);
		ActionLazy<EmposInfo> enforceLChangedBy = new ActionLazyCommom<EmposInfo>(option, EmposVisiMergeUsername.class);
		ActionLazy<EmposInfo> enforceCreatedBy = new ActionLazyCommom<EmposInfo>(option, EmposVisiEnforceCreatedBy.class);
		ActionLazy<EmposInfo> enforceCreatedOn = new ActionLazyCommom<EmposInfo>(option, EmposVisiEnforceCreatedOn.class);
		ActionLazy<EmposInfo> insert = new ActionLazyCommom<EmposInfo>(option, EmposVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceLChanged = new ActionStdCommom<EmposInfo>(option, EmposVisiEnforceLChanged.class);
		ActionLazy<EmposInfo> enforceLChangedBy = new ActionLazyCommom<EmposInfo>(option, EmposVisiMergeUsername.class);
		ActionLazy<EmposInfo> enforceCreatedBy = new ActionLazyCommom<EmposInfo>(option, EmposVisiEnforceCreatedBy.class);
		ActionLazy<EmposInfo> enforceCreatedOn = new ActionLazyCommom<EmposInfo>(option, EmposVisiEnforceCreatedOn.class);
		ActionLazy<EmposInfo> update = new ActionLazyCommom<EmposInfo>(option, EmposVisiDaoUpdate.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(update);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
