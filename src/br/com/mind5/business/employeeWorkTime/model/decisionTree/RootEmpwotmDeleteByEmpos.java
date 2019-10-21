package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmMergeToDelete;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootDelete;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceEmposKey;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckDeleteByEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpwotmDeleteByEmpos extends DeciTreeWriteTemplate<EmpwotmInfo> {
	
	public RootEmpwotmDeleteByEmpos(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		
		checker = new EmpwotmCheckDeleteByEmpos();
		queue.add(checker);
		
		 return new ModelCheckerQueue<EmpwotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceEmposKey = new StdEmpwotmEnforceEmposKey(option);
		ActionLazy<EmpwotmInfo> mergeToDelete = new LazyEmpwotmMergeToDelete(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> rootDelete = new LazyEmpwotmRootDelete(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceEmposKey);
		return actions;	
	}
}
