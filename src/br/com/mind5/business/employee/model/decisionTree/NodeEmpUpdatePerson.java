package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpPersonUpdate;
import br.com.mind5.business.employee.model.action.StdEmpEnforcePersonKey;
import br.com.mind5.business.employee.model.action.StdEmpSuccess;
import br.com.mind5.business.employee.model.checker.EmpCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpUpdatePerson extends DeciTreeTemplateWriteV2<EmpInfo> {
	
	public NodeEmpUpdatePerson(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpInfo> enforcePersonKey = new StdEmpEnforcePersonKey(option);
		ActionLazy<EmpInfo> updatePerson = new LazyEmpPersonUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(updatePerson);
		
		actions.add(enforcePersonKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpSuccess(option));		
		return actions;
	}
}
