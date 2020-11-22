package br.com.mind5.business.employeeMaterialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.action.LazyEmpmarchRootSelect;
import br.com.mind5.business.employeeMaterialSearch.model.action.StdEmpmarchEnforceEmpKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmpmarchSelectEmp extends DeciTreeTemplateRead<EmpmarchInfo> {
	
	public RootEmpmarchSelectEmp(DeciTreeOption<EmpmarchInfo> option) {
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
		
		ActionStd<EmpmarchInfo> enforceEmpKey = new StdEmpmarchEnforceEmpKey(option);
		ActionLazy<EmpmarchInfo> select = new LazyEmpmarchRootSelect(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(select);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
