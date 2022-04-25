package br.com.mind5.business.employeeWorkTimeRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.action.EmpworgVisiMergeToSelect;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckEmp;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckLangu;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckOwner;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckRead;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpworgRootSelect extends DeciTreeTemplateRead<EmpworgInfo> {
	
	public EmpworgRootSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpworgInfo> buildCheckerHook(DeciTreeOption<EmpworgInfo> option) {
		List<ModelChecker<EmpworgInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpworgInfo> checker;
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpworgInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpworgInfo> option) {
		List<ActionStd<EmpworgInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpworgInfo> mergeToSelect = new ActionStdCommom<EmpworgInfo>(option, EmpworgVisiMergeToSelect.class);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
