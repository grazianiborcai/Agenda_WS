package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpNodeSnapshot;
import br.com.mind5.business.employee.model.action.LazyEmpNodeUpdatePerson;
import br.com.mind5.business.employee.model.action.LazyEmpNodeUpsertAddress;
import br.com.mind5.business.employee.model.action.LazyEmpNodeUpsertPhone;
import br.com.mind5.business.employee.model.action.LazyEmpRootSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckUpdate;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpUpdate extends DeciTreeTemplateWrite<EmpInfo> {
	
	public RootEmpUpdate(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new EmpCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> updateEmployee = new NodeEmpUpdate(option).toAction();
		ActionLazy<EmpInfo> snapshot = new LazyEmpNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updatePerson = new LazyEmpNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertPhone = new LazyEmpNodeUpsertPhone(option.conn, option.schemaName);				
		ActionLazy<EmpInfo> select = new LazyEmpRootSelect(option.conn, option.schemaName);		
		
		updateEmployee.addPostAction(snapshot);	
		snapshot.addPostAction(updatePerson);
		snapshot.addPostAction(upsertAddress);		
		snapshot.addPostAction(upsertPhone);
		snapshot.addPostAction(select);
		
		actions.add(updateEmployee);
		return actions;
	}
}
