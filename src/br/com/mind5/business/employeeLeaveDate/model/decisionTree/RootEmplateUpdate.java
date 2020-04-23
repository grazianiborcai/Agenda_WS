package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceLChanged;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceValidFrom;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateEnforceValidTo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateMergeUsername;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateDaoUpdate;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateMergeToUpdate;
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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmplateUpdate extends DeciTreeTemplateWriteV2<EmplateInfo> {
	
	public RootEmplateUpdate(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelCheckerV1<EmplateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplateInfo> checker;			
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStdV1<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmplateInfo> mergeToUpdate = new StdEmplateMergeToUpdate(option);
		ActionLazyV1<EmplateInfo> enforceLChanged = new LazyEmplateEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<EmplateInfo> enforceLChangedBy = new LazyEmplateMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmplateInfo> enforceValidFrom = new LazyEmplateEnforceValidFrom(option.conn, option.schemaName);
		ActionLazyV1<EmplateInfo> enforceValidTo = new LazyEmplateEnforceValidTo(option.conn, option.schemaName);
		ActionLazyV1<EmplateInfo> update = new LazyEmplateDaoUpdate(option.conn, option.schemaName);
		ActionStdV1<EmplateInfo> select = new RootEmplateSelect(option).toAction();
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		enforceValidTo.addPostAction(update);
		
		actions.add(mergeToUpdate);
		actions.add(select);
		
		return actions;
	}
}
