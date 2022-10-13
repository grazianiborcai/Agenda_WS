package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiDaoInsert;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforceCreatedBy;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforceCreatedOn;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforceLChanged;
import br.com.mind5.business.personLegal.model.action.PeregVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregNodeInsert extends DeciTreeTemplateWrite<PeregInfo> {

	public PeregNodeInsert(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeregInfo> buildCheckerHook(DeciTreeOption<PeregInfo> option) {
		List<ModelChecker<PeregInfo>> queue = new ArrayList<>();		
		ModelChecker<PeregInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();

		ActionStd<PeregInfo> enforceLChanged = new ActionStdCommom<PeregInfo>(option, PeregVisiEnforceLChanged.class);
		ActionLazy<PeregInfo> mergeLChangedBy = new ActionLazyCommom<PeregInfo>(option, PeregVisiMergeUsername.class);	
		ActionLazy<PeregInfo> enforceCreatedBy = new ActionLazyCommom<PeregInfo>(option, PeregVisiEnforceCreatedBy.class);
		ActionLazy<PeregInfo> enforceCreatedOn = new ActionLazyCommom<PeregInfo>(option, PeregVisiEnforceCreatedOn.class);
		ActionLazy<PeregInfo> insertPersonLegal = new ActionLazyCommom<PeregInfo>(option, PeregVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertPersonLegal);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
