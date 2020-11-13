package br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.action.StdEmpwoutMergeToSelect;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckLangu;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckOwner;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckRead;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckStore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootEmpwoutSelect extends DeciTreeTemplateReadV2<EmpwoutInfo> {
	
	public RootEmpwoutSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpwoutInfo> buildCheckerHook(DeciTreeOption<EmpwoutInfo> option) {
		List<ModelCheckerV1<EmpwoutInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpwoutInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwoutCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwoutCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwoutCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwoutCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmpwoutInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwoutInfo> option) {
		List<ActionStdV2<EmpwoutInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmpwoutInfo> mergeToSelect = new StdEmpwoutMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
