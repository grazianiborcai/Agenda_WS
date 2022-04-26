package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiMergeEmpwotarchEmp;
import br.com.mind5.business.employeeWorkTime.model.action.EmpwotmVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpwotmRootSearchEmp extends DeciTreeTemplateRead<EmpwotmInfo> {
	
	public EmpwotmRootSearchEmp(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> mergeEmpwotarch = new ActionStdCommom<EmpwotmInfo>(option, EmpwotmVisiMergeEmpwotarchEmp.class);
		ActionLazy<EmpwotmInfo> select = new ActionLazyCommom<EmpwotmInfo>(option, EmpwotmVisiRootSelect.class);
		
		mergeEmpwotarch.addPostAction(select);
		
		actions.add(mergeEmpwotarch);
		return actions;
	}
}
