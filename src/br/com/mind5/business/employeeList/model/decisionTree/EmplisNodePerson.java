package br.com.mind5.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.action.EmplisVisiEnforcePersonKey;
import br.com.mind5.business.employeeList.model.action.EmplisVisiMergePerarch;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplisNodePerson extends DeciTreeTemplateWrite<EmplisInfo> {
	
	public EmplisNodePerson(DeciTreeOption<EmplisInfo> option) {
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

		ActionStd<EmplisInfo> enforcePersonKey = new ActionStdCommom<EmplisInfo>(option, EmplisVisiEnforcePersonKey.class);
		ActionLazy<EmplisInfo> mergePerarch = new ActionLazyCommom<EmplisInfo>(option, EmplisVisiMergePerarch.class);
		
		enforcePersonKey.addPostAction(mergePerarch);
		
		actions.add(enforcePersonKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplisInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStd<EmplisInfo>> actions = new ArrayList<>();

		ActionStd<EmplisInfo> success = new ActionStdSuccessCommom<EmplisInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
