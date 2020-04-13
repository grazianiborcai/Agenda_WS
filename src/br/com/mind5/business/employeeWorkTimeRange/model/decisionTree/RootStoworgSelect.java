package br.com.mind5.business.employeeWorkTimeRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.action.StdEmpworgMergeToSelect;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckEmp;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckLangu;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckOwner;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckRead;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootStoworgSelect extends DeciTreeTemplateReadV1<EmpworgInfo> {
	
	public RootStoworgSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpworgInfo> buildCheckerHook(DeciTreeOption<EmpworgInfo> option) {
		List<ModelCheckerV1<EmpworgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpworgInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpworgCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpworgCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpworgCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpworgCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpworgCheckEmp(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpworgInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpworgInfo> option) {
		List<ActionStdV1<EmpworgInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpworgInfo> mergeToSelect = new StdEmpworgMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
