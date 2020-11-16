package br.com.mind5.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmNodeDeleteFromEmpos;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceEmposKey;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckDeleteFromEmpos;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckEmp;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckOwner;
import br.com.mind5.business.employeeWorkTime.model.checker.EmpwotmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpwotmDeleteFromEmpos extends DeciTreeTemplateWrite<EmpwotmInfo> {
	
	public RootEmpwotmDeleteFromEmpos(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpwotmCheckDeleteFromEmpos(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwotmCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwotmCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwotmCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new EmpwotmCheckEmp(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<EmpwotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> enforceEmposKey = new StdEmpwotmEnforceEmposKey(option);
		ActionLazy<EmpwotmInfo> delete = new LazyEmpwotmNodeDeleteFromEmpos(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(delete);
		
		actions.add(enforceEmposKey);
		return actions;
	}
}
