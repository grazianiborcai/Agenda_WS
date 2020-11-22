package br.com.mind5.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatEnforceCreatedBy;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatEnforceCreatedOn;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatEnforceLChanged;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatMergeUsername;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatNodeInsert;
import br.com.mind5.business.employeeMaterial.model.action.LazyEmpmatRootSelect;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckEmp;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckLangu;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckMat;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckMatarchService;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckOwner;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpmatInsert extends DeciTreeTemplateWrite<EmpmatInfo> {
	
	public RootEmpmatInsert(DeciTreeOption<EmpmatInfo> option) {
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
		
		ActionStd<EmpmatInfo> nodeSytotauh = new NodeEmpmatSytotauhL1(option).toAction();
		ActionLazy<EmpmatInfo> enforceLChanged = new LazyEmpmatEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> enforceLChangedBy = new LazyEmpmatMergeUsername(option.conn, option.schemaName);		
		ActionLazy<EmpmatInfo> enforceCreatedBy = new LazyEmpmatEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> enforceCreatedOn = new LazyEmpmatEnforceCreatedOn(option.conn, option.schemaName);		
		ActionLazy<EmpmatInfo> nodeInsert = new LazyEmpmatNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmpmatInfo> select = new LazyEmpmatRootSelect(option.conn, option.schemaName);
		
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
