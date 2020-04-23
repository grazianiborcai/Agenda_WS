package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateMergeTimezone;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateMergeToSelect;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckEmp;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckOwner;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckRead;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckStorauth;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public class RootEmplateSelect extends DeciTreeTemplateReadV2<EmplateInfo> {
	
	public RootEmplateSelect(DeciTreeOption<EmplateInfo> option) {
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
		checker = new EmplateCheckRead(checkerOption);
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
		checker = new EmplateCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStdV1<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmplateInfo> select = new StdEmplateMergeToSelect(option);
		ActionLazyV1<EmplateInfo> mergeTimezone = new LazyEmplateMergeTimezone(option.conn, option.schemaName);
		
		select.addPostAction(mergeTimezone);
		
		actions.add(select);
		return actions;
	}
}
