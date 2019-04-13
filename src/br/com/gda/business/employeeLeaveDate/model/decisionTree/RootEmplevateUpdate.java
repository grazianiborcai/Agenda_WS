package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.LazyEmplevateMergeUsername;
import br.com.gda.business.employeeLeaveDate.model.action.LazyEmplevateUpdate;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateEnforceLChanged;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckExist;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckLangu;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckOwner;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckStorauth;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckStore;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckEmpos;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckTimeRange;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmplevateUpdate extends DeciTreeWriteTemplate<EmplevateInfo> {
	
	public RootEmplevateUpdate(DeciTreeOption<EmplevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplevateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplevateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checker = new EmplevateCheckWrite();
		queue.add(checker);
		
		checker = new EmplevateCheckTimeRange();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckEmpos(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplevateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplevateInfo> enforceLChanged = new StdEmplevateEnforceLChanged(option);
		ActionLazy<EmplevateInfo> enforceLChangedBy = new LazyEmplevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> update = new LazyEmplevateUpdate(option.conn, option.schemaName);
		ActionStd<EmplevateInfo> select = new RootEmplevateSelect(option).toAction();
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		actions.add(enforceLChanged);
		actions.add(select);
		
		return actions;
	}
}
