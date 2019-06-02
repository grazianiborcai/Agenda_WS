package br.com.gda.business.employeeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.model.action.LazyEmpnapRootSelect;
import br.com.gda.business.employeeSnapshot.model.action.StdEmpnapInsert;
import br.com.gda.business.employeeSnapshot.model.checker.EmpnapCheckEmp;
import br.com.gda.business.employeeSnapshot.model.checker.EmpnapCheckOwner;
import br.com.gda.business.employeeSnapshot.model.checker.EmpnapCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

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
		ActionLazy<EmpnapInfo> select = new LazyEmpnapRootSelect(option.conn, option.schemaName);
		
	//	insert.addPostAction(select);
		
		actions.add(insert);	
		return actions;
	}
}
