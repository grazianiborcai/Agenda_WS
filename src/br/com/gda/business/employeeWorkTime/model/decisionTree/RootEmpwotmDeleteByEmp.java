package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmMergeToDelete;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmRootDelete;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmEnforceEmpKey;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckDeleteByEmp;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpwotmDeleteByEmp extends DeciTreeWriteTemplate<EmpwotmInfo> {
	
	public RootEmpwotmDeleteByEmp(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		
		checker = new EmpwotmCheckDeleteByEmp();
		queue.add(checker);
		
		 return new ModelCheckerQueue<EmpwotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceEmpKey = new StdEmpwotmEnforceEmpKey(option);
		ActionLazy<EmpwotmInfo> mergeToDelete = new LazyEmpwotmMergeToDelete(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> rootDelete = new LazyEmpwotmRootDelete(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceEmpKey);
		return actions;	
	}
}
