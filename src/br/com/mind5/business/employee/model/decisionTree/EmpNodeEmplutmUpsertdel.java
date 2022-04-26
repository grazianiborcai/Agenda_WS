package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiEmplutmUpsertdel;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceEmplutmKey;
import br.com.mind5.business.employee.model.checker.EmpCheckHasEmplutm;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodeEmplutmUpsertdel extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpNodeEmplutmUpsertdel(DeciTreeOption<EmpInfo> option) {
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
		checker = new EmpCheckHasEmplutm(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceEmplutmKey = new ActionStdCommom<EmpInfo>(option, EmpVisiEnforceEmplutmKey.class);
		ActionLazy<EmpInfo> upsertdelEmplutm = new  ActionLazyCommom<EmpInfo>(option, EmpVisiEmplutmUpsertdel.class);	
		
		enforceEmplutmKey.addPostAction(upsertdelEmplutm);
		
		actions.add(enforceEmplutmKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> sucess = new ActionStdSuccessCommom<EmpInfo>(option);		
		
		actions.add(sucess);		
		return actions;
	}
}
