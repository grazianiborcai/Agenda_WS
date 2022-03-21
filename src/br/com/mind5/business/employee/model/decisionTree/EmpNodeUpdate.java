package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSytotauh;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLChanged;
import br.com.mind5.business.employee.model.action.EmpVisiMergeToUpdate;
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

public final class EmpNodeUpdate extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpNodeUpdate(DeciTreeOption<EmpInfo> option) {
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

		ActionStd<EmpInfo> mergeToUpdate = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeToUpdate.class);
		ActionLazy<EmpInfo> nodeSytotauh = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeSytotauh.class);
		ActionLazy<EmpInfo> enforceLChanged = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceLChanged.class);
		ActionLazy<EmpInfo> enforceLChangedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUsername.class);
		ActionLazy<EmpInfo> updateEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateEmployee);	
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
