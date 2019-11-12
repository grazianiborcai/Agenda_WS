package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmMergeEmpwoco;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwotmConflict extends DeciTreeReadTemplate<EmpwotmInfo> {
	
	public RootEmpwotmConflict(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;

		checker = new EmpwotmCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> mergeEmpwoco = new StdEmpwotmMergeEmpwoco(option);
		ActionLazy<EmpwotmInfo> select = new LazyEmpwotmRootSelect(option.conn, option.schemaName);
		
		mergeEmpwoco.addPostAction(select);
		
		actions.add(mergeEmpwoco);
		return actions;
	}
}
