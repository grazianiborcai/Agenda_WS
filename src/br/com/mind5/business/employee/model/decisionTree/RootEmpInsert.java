package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertAddress;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertPerson;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertPhone;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertUser;
import br.com.mind5.business.employee.model.action.LazyEmpNodeSnapshot;
import br.com.mind5.business.employee.model.action.LazyEmpRootSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckInsert;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmpInsert extends DeciTreeTemplateWriteV2<EmpInfo> {	
	
	public RootEmpInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpCheckInsert(checkerOption);
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStdV1<EmpInfo> insertEmployee = new NodeEmpInsert(option).toAction();	
		ActionLazyV1<EmpInfo> insertPerson = new LazyEmpNodeInsertPerson(option.conn, option.schemaName);	
		ActionLazyV1<EmpInfo> insertUser = new LazyEmpNodeInsertUser(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> snapshot = new LazyEmpNodeSnapshot(option.conn, option.schemaName);	
		ActionLazyV1<EmpInfo> insertAddress = new LazyEmpNodeInsertAddress(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> insertPhone = new LazyEmpNodeInsertPhone(option.conn, option.schemaName);		
		ActionLazyV1<EmpInfo> select = new LazyEmpRootSelect(option.conn, option.schemaName);	
		
		insertEmployee.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertUser);		
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(insertAddress);		
		snapshot.addPostAction(insertPhone);			
		snapshot.addPostAction(select);
		
		actions.add(insertEmployee);	
		return actions;
	}
}
