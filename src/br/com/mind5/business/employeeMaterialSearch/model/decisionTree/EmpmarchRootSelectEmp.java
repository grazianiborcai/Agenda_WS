package br.com.mind5.business.employeeMaterialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.action.EmpmarchVisiRootSelect;
import br.com.mind5.business.employeeMaterialSearch.model.action.EmpmarchVisiEnforceEmpKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpmarchRootSelectEmp extends DeciTreeTemplateRead<EmpmarchInfo> {
	
	public EmpmarchRootSelectEmp(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmarchInfo> buildCheckerHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ModelChecker<EmpmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmarchInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmarchInfo> option) {
		List<ActionStd<EmpmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmarchInfo> enforceEmpKey = new ActionStdCommom<EmpmarchInfo>(option, EmpmarchVisiEnforceEmpKey.class);
		ActionLazy<EmpmarchInfo> select = new ActionLazyCommom<EmpmarchInfo>(option, EmpmarchVisiRootSelect.class);
		
		enforceEmpKey.addPostAction(select);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
