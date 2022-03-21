package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiDaoDelete;
import br.com.mind5.business.employee.model.action.EmpVisiObfuscate;
import br.com.mind5.business.employee.model.action.EmpVisiPersonDelete;
import br.com.mind5.business.employee.model.action.EmpVisiUserDemote;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodeDeleteL2 extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public EmpNodeDeleteL2(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmpInfo> deletePerson = new ActionStdCommom<EmpInfo>(option, EmpVisiPersonDelete.class);
		ActionLazy<EmpInfo> deleteEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoDelete.class);
		ActionLazy<EmpInfo> demoteUser = new ActionLazyCommom<EmpInfo>(option, EmpVisiUserDemote.class);		
		ActionLazy<EmpInfo> obfuscate = new ActionLazyCommom<EmpInfo>(option, EmpVisiObfuscate.class);	
		
		deletePerson.addPostAction(deleteEmployee);
		deletePerson.addPostAction(demoteUser);
		deletePerson.addPostAction(obfuscate);
		
		actions.add(deletePerson);	
		return actions;
	}
}
