package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLChanged;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLockedOn;
import br.com.mind5.business.employee.model.action.EmpVisiMergeToSelect;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUsername;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSytotauh;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpRootInactivate extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpRootInactivate(DeciTreeOption<EmpInfo> option) {
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
		checker = new EmpCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> mergeToSelect = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeToSelect.class);
		ActionLazy<EmpInfo> nodeSytotauh = new ActionLazyCommom<EmpInfo>(option.conn, option.schemaName, EmpVisiNodeSytotauh.class);
		ActionLazy<EmpInfo> enforceLockedOn = new ActionLazyCommom<EmpInfo>(option.conn, option.schemaName, EmpVisiEnforceLockedOn.class);
		ActionLazy<EmpInfo> enforceLChanged = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceLChanged.class);
		ActionLazy<EmpInfo> enforceLChangedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUsername.class);
		ActionLazy<EmpInfo> updateEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);
		
		mergeToSelect.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLockedOn);
		enforceLockedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateEmployee);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
