package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertPerson;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertSnapshot;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertUser;
import br.com.mind5.business.employee.model.action.LazyEmpNodeUpsertAddress;
import br.com.mind5.business.employee.model.action.LazyEmpNodeUpsertPhone;
import br.com.mind5.business.employee.model.action.LazyEmpRootSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckGenField;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpInsert extends DeciTreeWriteTemplate<EmpInfo> {	
	
	public RootEmpInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpCheckWrite();
		queue.add(checker);
		
		checker = new EmpCheckGenField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStd<EmpInfo> insertEmployee = new NodeEmpInsert(option).toAction();	
		ActionLazy<EmpInfo> insertPerson = new LazyEmpNodeInsertPerson(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> insertUser = new LazyEmpNodeInsertUser(option.conn, option.schemaName);
		ActionLazy<EmpInfo> snapshot = new LazyEmpNodeInsertSnapshot(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertPhone = new LazyEmpNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<EmpInfo> select = new LazyEmpRootSelect(option.conn, option.schemaName);	
		
		insertEmployee.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertUser);		
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);		
		snapshot.addPostAction(upsertPhone);			
		snapshot.addPostAction(select);
		
		actions.add(insertEmployee);	
		return actions;
	}
}
