package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeAddressUpsert;
import br.com.mind5.business.employee.model.action.EmpVisiNodePersonUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiNodePhoneUpsert;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSnapshot;
import br.com.mind5.business.employee.model.action.EmpVisiRootSelect;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpRootUpdate extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpRootUpdate(DeciTreeOption<EmpInfo> option) {
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

		ActionStd<EmpInfo> updateEmployee = new EmpNodeUpdate(option).toAction();
		ActionLazy<EmpInfo> snapshot = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeSnapshot.class);
		ActionLazy<EmpInfo> updatePerson = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodePersonUpdate.class);
		ActionLazy<EmpInfo> upsertAddress = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeAddressUpsert.class);
		ActionLazy<EmpInfo> upsertPhone = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodePhoneUpsert.class);				
		ActionLazy<EmpInfo> select = new ActionLazyCommom<EmpInfo>(option, EmpVisiRootSelect.class);		
		
		updateEmployee.addPostAction(snapshot);	
		snapshot.addPostAction(updatePerson);
		snapshot.addPostAction(upsertAddress);		
		snapshot.addPostAction(upsertPhone);
		snapshot.addPostAction(select);
		
		actions.add(updateEmployee);
		return actions;
	}
}
