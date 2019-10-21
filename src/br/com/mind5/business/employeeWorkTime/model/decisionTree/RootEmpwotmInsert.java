package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmMergeUsername;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmNodeInsert;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmRootSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceLChanged;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckEmp;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckEmpos;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckEmpwoco;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckExist;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckOwner;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckRange;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckRangeLen;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStorauth;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStore;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStowotm;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckWeekday;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpwotmInsert extends DeciTreeWriteTemplate<EmpwotmInfo> {
	
	public RootEmpwotmInsert(DeciTreeOption<EmpwotmInfo> option) {
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
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
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
		ActionLazy<EmpwotmInfo> nodeInsert = new LazyEmpwotmNodeInsert(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> select = new LazyEmpwotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
