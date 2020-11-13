package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceCreatedBy;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceCreatedOn;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceValidFrom;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceValidTo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateMergeUsername;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateNodeInsert;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateRootSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateEnforceLChanged;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckEmp;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckEmposarch;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckExist;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckOwner;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckSchedage;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckStorauth;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckStore;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckTimeRange;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmplateInsert extends DeciTreeTemplateWrite<EmplateInfo> {

	public RootEmplateInsert(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplateCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new EmplateCheckTimeRange(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckEmposarch(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmplateCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplateCheckStorauth(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmplateCheckSchedage(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> enforceLChanged = new StdEmplateEnforceLChanged(option);
		ActionLazy<EmplateInfo> enforceLChangedBy = new LazyEmplateMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> enforceCreatedBy = new LazyEmplateEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> enforceCreatedOn = new LazyEmplateEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> enforceValidFrom = new LazyEmplateEnforceValidFrom(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> enforceValidTo = new LazyEmplateEnforceValidTo(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> nodeInsert = new LazyEmplateNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmplateInfo> select = new LazyEmplateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);		
		enforceValidTo.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
