package br.com.mind5.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.action.LazyEmplisMergePerarch;
import br.com.mind5.business.employeeList.model.action.StdEmplisEnforcePersonKey;
import br.com.mind5.business.employeeList.model.action.StdEmplisSuccess;
import br.com.mind5.business.employeeList.model.checker.EmplisCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmplisPerson extends DeciTreeTemplateWriteV2<EmplisInfo> {
	
	public NodeEmplisPerson(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplisInfo> buildCheckerHook(DeciTreeOption<EmplisInfo> option) {
		List<ModelCheckerV1<EmplisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplisCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmplisInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStdV2<EmplisInfo>> actions = new ArrayList<>();

		ActionStdV2<EmplisInfo> enforcePersonKey = new StdEmplisEnforcePersonKey(option);
		ActionLazy<EmplisInfo> mergePerarch = new LazyEmplisMergePerarch(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(mergePerarch);
		
		actions.add(enforcePersonKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<EmplisInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStdV2<EmplisInfo>> actions = new ArrayList<>();

		ActionStdV2<EmplisInfo> success = new StdEmplisSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
