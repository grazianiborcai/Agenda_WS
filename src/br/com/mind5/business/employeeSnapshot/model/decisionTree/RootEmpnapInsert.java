package br.com.mind5.business.employeeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapInsert;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckEmp;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckOwner;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpnapInsert extends DeciTreeWriteTemplate<EmpnapInfo> {	
	
	public RootEmpnapInsert(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpnapInfo> buildDecisionCheckerHook(DeciTreeOption<EmpnapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpnapInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpnapCheckEmp(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpnapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpnapInfo> option) {
		List<ActionStd<EmpnapInfo>> actions = new ArrayList<>();

		ActionStd<EmpnapInfo> insert = new StdEmpnapInsert(option);
		
		actions.add(insert);	
		return actions;
	}
}
