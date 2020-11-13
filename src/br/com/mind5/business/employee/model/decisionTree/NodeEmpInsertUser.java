package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoUpdate;
import br.com.mind5.business.employee.model.action.LazyEmpUserPromote;
import br.com.mind5.business.employee.model.action.StdEmpMergeUserarch;
import br.com.mind5.business.employee.model.action.StdEmpUserInsert;
import br.com.mind5.business.employee.model.checker.EmpCheckUserarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpInsertUser extends DeciTreeTemplateWriteV2<EmpInfo> {
	
	public NodeEmpInsertUser(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckUserarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV2<EmpInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpInfo> mergeUserarch = new StdEmpMergeUserarch(option);
		ActionLazy<EmpInfo> promoteUser = new LazyEmpUserPromote(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpDaoUpdate(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(promoteUser);
		promoteUser.addPostAction(updateEmployee);
		
		actions.add(mergeUserarch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV2<EmpInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpInfo> insertUser = new StdEmpUserInsert(option);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpDaoUpdate(option.conn, option.schemaName);
		
		insertUser.addPostAction(updateEmployee);
		
		actions.add(insertUser);	
		return actions;
	}
}
