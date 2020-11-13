package br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.action.StdEmpwoutMergeToSelect;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckLangu;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckOwner;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckRead;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmpwoutSelect extends DeciTreeTemplateRead<EmpwoutInfo> {
	
	public RootEmpwoutSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwoutInfo> buildCheckerHook(DeciTreeOption<EmpwoutInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwoutInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwoutInfo> option) {
		List<ActionStd<EmpwoutInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwoutInfo> mergeToSelect = new StdEmpwoutMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
