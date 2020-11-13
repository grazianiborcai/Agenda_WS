package br.com.mind5.business.employeeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.action.LazyEmpnapDaoInsert;
import br.com.mind5.business.employeeSnapshot.model.action.LazyEmpnapMergeUselis;
import br.com.mind5.business.employeeSnapshot.model.action.StdEmpnapMergePersolis;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckEmp;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckLangu;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckOwner;
import br.com.mind5.business.employeeSnapshot.model.checker.EmpnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpnapInsert extends DeciTreeTemplateWrite<EmpnapInfo> {	
	
	public RootEmpnapInsert(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpnapInfo> buildCheckerHook(DeciTreeOption<EmpnapInfo> option) {
		List<ModelChecker<EmpnapInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpnapInfo> checker;
		ModelCheckerOption checkerOption;		

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpnapCheckEmp(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpnapInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpnapInfo> option) {
		List<ActionStd<EmpnapInfo>> actions = new ArrayList<>();

		ActionStd<EmpnapInfo> mergePersolis = new StdEmpnapMergePersolis(option);
		ActionLazy<EmpnapInfo> mergeUselis = new LazyEmpnapMergeUselis(option.conn, option.schemaName);
		ActionLazy<EmpnapInfo> insert = new LazyEmpnapDaoInsert(option.conn, option.schemaName);
		
		mergePersolis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(insert);
		
		actions.add(mergePersolis);	
		return actions;
	}
}
