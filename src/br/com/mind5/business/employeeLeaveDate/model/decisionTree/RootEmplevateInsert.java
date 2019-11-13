package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateMergeUsername;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateNodeInsert;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateRootSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateEnforceLChanged;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckEmp;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckEmposarch;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckExist;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckOwner;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckStorauth;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckStore;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckTimeRange;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmplevateInsert extends DeciTreeWriteTemplate<EmplevateInfo> {

	public RootEmplevateInsert(DeciTreeOption<EmplevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplevateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplevateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
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
		checker = new EmplevateCheckEmposarch(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmplevateCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckStorauth(checkerOption);
		queue.add(checker);	
		//TODO: verificar se ha agendamento
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplevateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplevateInfo> enforceLChanged = new StdEmplevateEnforceLChanged(option);
		ActionLazy<EmplevateInfo> enforceLChangedBy = new LazyEmplevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> nodeInsert = new LazyEmplevateNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> select = new LazyEmplevateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
