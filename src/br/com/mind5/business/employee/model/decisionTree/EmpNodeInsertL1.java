package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiDaoInsert;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceCreatedBy;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceCreatedOn;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLChanged;
import br.com.mind5.business.employee.model.action.EmpVisiMergeSytotauh;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpNodeInsertL1 extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public EmpNodeInsertL1(DeciTreeOption<EmpInfo> option) {
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
		
		ActionStd<EmpInfo> enforceLChanged = new ActionStdCommom<EmpInfo>(option, EmpVisiEnforceLChanged.class);
		ActionLazy<EmpInfo> enforceLChangedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUsername.class);
		ActionLazy<EmpInfo> enforceCreatedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceCreatedBy.class);
		ActionLazy<EmpInfo> enforceCreatedOn = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceCreatedOn.class);
		ActionLazy<EmpInfo> mergeSytotauh = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeSytotauh.class);
		ActionLazy<EmpInfo> insertEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoInsert.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertEmployee);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
