package br.com.gda.business.employeeWorkTimeOutlier.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.model.action.LazyEmpwoutMergeStolis;
import br.com.gda.business.employeeWorkTimeOutlier.model.action.LazyEmpwoutMergeWeekday;
import br.com.gda.business.employeeWorkTimeOutlier.model.action.StdEmpwoutMergeToSelect;
import br.com.gda.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckLangu;
import br.com.gda.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckOwner;
import br.com.gda.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckRead;
import br.com.gda.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckStore;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwoutSelect extends DeciTreeReadTemplate<EmpwoutInfo> {
	
	public RootEmpwoutSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwoutInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwoutInfo> option) {
		List<ModelChecker<EmpwoutInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwoutInfo> checker;
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwoutInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwoutInfo> option) {
		List<ActionStd<EmpwoutInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwoutInfo> mergeToSelect = new StdEmpwoutMergeToSelect(option);
		ActionLazy<EmpwoutInfo> mergeStolis = new LazyEmpwoutMergeStolis(option.conn, option.schemaName);
		ActionLazy<EmpwoutInfo> mergeWeekday = new LazyEmpwoutMergeWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeStolis);	
		mergeStolis.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
