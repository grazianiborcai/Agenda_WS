package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeUserInsertL2;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUselis;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUserarch;
import br.com.mind5.business.employee.model.action.EmpVisiUserInsert;
import br.com.mind5.business.employee.model.action.EmpVisiUserPromote;
import br.com.mind5.business.employee.model.checker.EmpCheckUserarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodeUserInsertL1 extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpNodeUserInsertL1(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckUserarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> mergeUserarch = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeUserarch.class);
		ActionLazy<EmpInfo> promoteUser = new ActionLazyCommom<EmpInfo>(option, EmpVisiUserPromote.class);
		ActionLazy<EmpInfo> updateEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);
		ActionLazy<EmpInfo> mergeUselis = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUselis.class);
		ActionLazy<EmpInfo> nodeL2 = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeUserInsertL2.class);
		
		mergeUserarch.addPostAction(promoteUser);
		promoteUser.addPostAction(updateEmployee);
		updateEmployee.addPostAction(mergeUselis);
		mergeUselis.addPostAction(nodeL2);
		
		actions.add(mergeUserarch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> insertUser = new ActionStdCommom<EmpInfo>(option, EmpVisiUserInsert.class);
		ActionLazy<EmpInfo> updateEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);
		
		insertUser.addPostAction(updateEmployee);
		
		actions.add(insertUser);	
		return actions;
	}
}
