package br.com.mind5.business.employeeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.action.LazyEmparchRootSelect;
import br.com.mind5.business.employeeSearch.model.action.StdEmparchEnforceUserKey;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckReadUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmparchSelectUser extends DeciTreeTemplateRead<EmparchInfo> {
	
	public RootEmparchSelectUser(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmparchInfo> buildCheckerHook(DeciTreeOption<EmparchInfo> option) {
		List<ModelChecker<EmparchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmparchCheckReadUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmparchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmparchInfo> option) {
		List<ActionStd<EmparchInfo>> actions = new ArrayList<>();

		ActionStd<EmparchInfo> enforceUserKey = new StdEmparchEnforceUserKey(option);
		ActionLazy<EmparchInfo> select = new LazyEmparchRootSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
