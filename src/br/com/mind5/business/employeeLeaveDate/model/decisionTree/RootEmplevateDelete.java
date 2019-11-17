package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateDelete;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateEnforceLChanged;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateMergeUsername;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateUpdate;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateMergeToDelete;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckDelete;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckEmp;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckExist;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckOwner;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckStorauth;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmplevateDelete extends DeciTreeWriteTemplate<EmplevateInfo> {
	
	public RootEmplevateDelete(DeciTreeOption<EmplevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplevateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplevateInfo> option) {
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplevateCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckStore(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplevateCheckStorauth(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<EmplevateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplevateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplevateInfo> mergeToDelete = new StdEmplevateMergeToDelete(option);
		ActionLazy<EmplevateInfo> enforceLChanged = new LazyEmplevateEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> enforceLChangedBy = new LazyEmplevateMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> update = new LazyEmplevateUpdate(option.conn, option.schemaName);
		ActionLazy<EmplevateInfo> delete = new LazyEmplevateDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;	
	}
}
