package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiEnforcePersonKey;
import br.com.mind5.business.employee.model.action.EmpVisiPersonInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodePersonInsert extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpNodePersonInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforcePersonKey = new ActionStdCommom<EmpInfo>(option, EmpVisiEnforcePersonKey.class);
		ActionLazy<EmpInfo> insertPerson = new ActionLazyCommom<EmpInfo>(option, EmpVisiPersonInsert.class);
		ActionLazy<EmpInfo> updateEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);
		
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(updateEmployee);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
