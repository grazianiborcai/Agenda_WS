package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateMergeToDelete;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateRootDelete;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateEnforceEmposKey;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckDeleteByEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmplevateDeleteByEmpos extends DeciTreeWriteTemplate<EmplevateInfo> {
	
	public RootEmplevateDeleteByEmpos(DeciTreeOption<EmplevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplevateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplevateInfo> option) {
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;
		
		checker = new EmplevateCheckDeleteByEmpos();
		queue.add(checker);
		
		 return new ModelCheckerQueue<EmplevateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplevateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplevateInfo> enforceEmposKey = new StdEmplevateEnforceEmposKey(option);
		ActionLazy<EmplevateInfo> mergeToDelete = new LazyEmplevateMergeToDelete(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> rootDelete = new LazyEmplevateRootDelete(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceEmposKey);
		return actions;	
	}
}
