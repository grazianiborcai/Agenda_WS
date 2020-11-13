package br.com.mind5.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.action.LazyEmplisMergePerarch;
import br.com.mind5.business.employeeList.model.action.StdEmplisEnforcePersonKey;
import br.com.mind5.business.employeeList.model.action.StdEmplisSuccess;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmplisPerson extends DeciTreeTemplateWrite<EmplisInfo> {
	
	public NodeEmplisPerson(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplisInfo> buildCheckerHook(DeciTreeOption<EmplisInfo> option) {
		List<ModelChecker<EmplisInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplisCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplisInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStd<EmplisInfo>> actions = new ArrayList<>();

		ActionStd<EmplisInfo> enforcePersonKey = new StdEmplisEnforcePersonKey(option);
		ActionLazy<EmplisInfo> mergePerarch = new LazyEmplisMergePerarch(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(mergePerarch);
		
		actions.add(enforcePersonKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplisInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStd<EmplisInfo>> actions = new ArrayList<>();

		ActionStd<EmplisInfo> success = new StdEmplisSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
