package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmMergeEmpwout;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwotmOutlier extends DeciTreeReadTemplate<EmpwotmInfo> {
	
	public RootEmpwotmOutlier(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;

		checker = new EmpwotmCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStdV1<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpwotmInfo> mergeEmpwout = new StdEmpwotmMergeEmpwout(option);
		ActionLazyV1<EmpwotmInfo> select = new LazyEmpwotmRootSelect(option.conn, option.schemaName);
		
		mergeEmpwout.addPostAction(select);
		
		actions.add(mergeEmpwout);
		return actions;
	}
}
