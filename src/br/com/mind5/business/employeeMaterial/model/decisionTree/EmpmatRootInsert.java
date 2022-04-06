package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiNodeInsert;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiRootSelect;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiEnforceCreatedBy;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiEnforceCreatedOn;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiEnforceLChanged;
import br.com.mind5.business.employeeMaterial.model.action.EmpmatVisiMergeUsername;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckEmp;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckMat;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckMatarchService;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckOwner;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpmatRootInsert extends DeciTreeTemplateWrite<EmpmatInfo> {
	
	public EmpmatRootInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpmatInfo> buildCheckerHook(DeciTreeOption<EmpmatInfo> option) {		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpmatCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpmatCheckMatarchService(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmpmatCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpmatInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpmatInfo> nodeSytotauh = new EmpmatNodeSytotauhL1(option).toAction();
		ActionLazy<EmpmatInfo> enforceLChanged = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiEnforceLChanged.class);
		ActionLazy<EmpmatInfo> enforceLChangedBy = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiMergeUsername.class);		
		ActionLazy<EmpmatInfo> enforceCreatedBy = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiEnforceCreatedBy.class);
		ActionLazy<EmpmatInfo> enforceCreatedOn = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiEnforceCreatedOn.class);		
		ActionLazy<EmpmatInfo> nodeInsert = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiNodeInsert.class);
		ActionLazy<EmpmatInfo> select = new ActionLazyCommom<EmpmatInfo>(option, EmpmatVisiRootSelect.class);
		
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(nodeSytotauh);
		return actions;
	}
}
