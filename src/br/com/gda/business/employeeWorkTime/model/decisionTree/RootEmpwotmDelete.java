package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmDelete;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmEnforceLChanged;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmMergeUsername;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmUpdate;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmMergeToDelete;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckExist;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckStorauth;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpwotmDelete extends DeciTreeWriteTemplate<EmpwotmInfo> {
	
	public RootEmpwotmDelete(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checker = new EmpwotmCheckWrite();
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
		checker = new EmpwotmCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckStorauth(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<EmpwotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> mergeToDelete = new StdEmpwotmMergeToDelete(option);
		ActionLazy<EmpwotmInfo> enforceLChanged = new LazyEmpwotmEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> enforceLChangedBy = new LazyEmpwotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> update = new LazyEmpwotmUpdate(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> delete = new LazyEmpwotmDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;	
	}
}
