package br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.action.StdEmpwocoMergeToSelect;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckEmp;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckLangu;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckOwner;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckRead;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwocoSelect extends DeciTreeReadTemplate<EmpwocoInfo> {
	
	public RootEmpwocoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwocoInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ModelChecker<EmpwocoInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwocoInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwocoCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwocoCheckEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpwocoInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ActionStdV1<EmpwocoInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmpwocoInfo> select = new StdEmpwocoMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
