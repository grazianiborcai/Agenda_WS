package br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.action.StdEmpwotarchMergeToSelect;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckLangu;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckOwner;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwotarchSelect extends DeciTreeReadTemplate<EmpwotarchInfo> {
	
	public RootEmpwotarchSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotarchInfo> buildCheckerHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ModelChecker<EmpwotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpwotarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotarchInfo> option) {
		List<ActionStdV1<EmpwotarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpwotarchInfo> select = new StdEmpwotarchMergeToSelect(option);

		actions.add(select);
		return actions;
	}
}
