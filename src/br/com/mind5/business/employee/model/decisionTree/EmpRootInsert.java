package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeAddressInsert;
import br.com.mind5.business.employee.model.action.EmpVisiNodeInsertExtra;
import br.com.mind5.business.employee.model.action.EmpVisiNodePersonInsert;
import br.com.mind5.business.employee.model.action.EmpVisiNodePhoneInsert;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSnapshot;
import br.com.mind5.business.employee.model.action.EmpVisiNodeUserInsertL1;
import br.com.mind5.business.employee.model.action.EmpVisiRootSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckInsert;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpRootInsert extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public EmpRootInsert(DeciTreeOption<EmpInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStd<EmpInfo> insertEmployee = new EmpNodeInsertL1(option).toAction();	
		ActionLazy<EmpInfo> insertPerson = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodePersonInsert.class);	
		ActionLazy<EmpInfo> insertUser = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeUserInsertL1.class);
		ActionLazy<EmpInfo> snapshot = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeSnapshot.class);	
		ActionLazy<EmpInfo> insertAddress = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeAddressInsert.class);
		ActionLazy<EmpInfo> insertPhone = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodePhoneInsert.class);
		ActionLazy<EmpInfo> insertExtra = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeInsertExtra.class);
		ActionLazy<EmpInfo> select = new ActionLazyCommom<EmpInfo>(option, EmpVisiRootSelect.class);	
		
		insertEmployee.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertUser);		
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(insertAddress);		
		snapshot.addPostAction(insertPhone);			
		snapshot.addPostAction(insertExtra);
		insertExtra.addPostAction(select);
		
		actions.add(insertEmployee);	
		return actions;
	}
}
