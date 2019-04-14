package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckEmp;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckExist;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmMergeUsername;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmUpdate;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmEnforceLChanged;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckEmpwoco;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckOwner;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckRange;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckRangeLen;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckStorauth;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckStore;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckEmpos;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckStowotm;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckWeekday;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpwotmUpdate extends DeciTreeWriteTemplate<EmpwotmInfo> {
	
	public RootEmpwotmUpdate(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checker = new EmpwotmCheckWrite();
		queue.add(checker);
		
		checker = new EmpwotmCheckRange();
		queue.add(checker);

		checker = new EmpwotmCheckRangeLen();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckWeekday(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckEmpos(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckStowotm(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpwotmCheckEmpwoco(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckStorauth(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceLChanged = new StdEmpwotmEnforceLChanged(option);
		ActionLazy<EmpwotmInfo> enforceLChangedBy = new LazyEmpwotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> update = new LazyEmpwotmUpdate(option.conn, option.schemaName);
		ActionStd<EmpwotmInfo> select = new RootEmpwotmSelect(option).toAction();
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		actions.add(enforceLChanged);
		actions.add(select);
		
		return actions;
	}
}
