package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootDelete;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmMergeEmpwotarch;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckDeleteByEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotmCheckDeleteByEmpos(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<EmpwotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> mergeEmpwotarch = new StdEmpwotmMergeEmpwotarch(option);
		ActionLazy<EmpwotmInfo> delete = new LazyEmpwotmRootDelete(option.conn, option.schemaName);
		
		mergeEmpwotarch.addPostAction(delete);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
}
