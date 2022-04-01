package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.CompVisiDaoInsert;
import br.com.mind5.business.company.model.action.CompVisiEnforceCreatedBy;
import br.com.mind5.business.company.model.action.CompVisiEnforceCreatedOn;
import br.com.mind5.business.company.model.action.CompVisiEnforceLChanged;
import br.com.mind5.business.company.model.action.CompVisiEnforceNameSearch;
import br.com.mind5.business.company.model.action.CompVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CompNodeInsert extends DeciTreeTemplateWrite<CompInfo> {
	
	public CompNodeInsert(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> enforceLChanged = new ActionStdCommom<CompInfo>(option, CompVisiEnforceLChanged.class);
		ActionLazy<CompInfo> enforceLChangedBy = new ActionLazyCommom<CompInfo>(option, CompVisiMergeUsername.class);
		ActionLazy<CompInfo> enforceCreatedOn = new ActionLazyCommom<CompInfo>(option, CompVisiEnforceCreatedOn.class);	
		ActionLazy<CompInfo> enforceCreatedBy = new ActionLazyCommom<CompInfo>(option, CompVisiEnforceCreatedBy.class);
		ActionLazy<CompInfo> enforceNameSearch = new ActionLazyCommom<CompInfo>(option, CompVisiEnforceNameSearch.class);
		ActionLazy<CompInfo> insert = new ActionLazyCommom<CompInfo>(option, CompVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
