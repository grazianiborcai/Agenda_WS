package br.com.mind5.business.employeeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.action.LazyEmparchRootSelect;
import br.com.mind5.business.employeeSearch.model.action.StdEmparchEnforceSytotauhKey;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckReadSytotauh;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmparchSelectSytotauh extends DeciTreeTemplateRead<EmparchInfo> {
	
	public RootEmparchSelectSytotauh(DeciTreeOption<EmparchInfo> option) {
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
		checker = new EmparchCheckReadSytotauh(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmparchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmparchInfo> option) {
		List<ActionStd<EmparchInfo>> actions = new ArrayList<>();

		ActionStd<EmparchInfo> enforceSytotauhKey = new StdEmparchEnforceSytotauhKey(option);
		ActionLazy<EmparchInfo> select = new LazyEmparchRootSelect(option.conn, option.schemaName);
		
		enforceSytotauhKey.addPostAction(select);
		
		actions.add(enforceSytotauhKey);
		return actions;
	}
}
