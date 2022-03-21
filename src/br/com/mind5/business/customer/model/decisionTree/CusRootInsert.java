package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiNodeAddressInsert;
import br.com.mind5.business.customer.model.action.CusVisiNodePersonInsert;
import br.com.mind5.business.customer.model.action.CusVisiNodePhoneInsert;
import br.com.mind5.business.customer.model.action.CusVisiNodeSnapshot;
import br.com.mind5.business.customer.model.action.CusVisiRootSelect;
import br.com.mind5.business.customer.model.checker.CusCheckInsert;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusRootInsert extends DeciTreeTemplateWrite<CusInfo> {

	public CusRootInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;		
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> insertCustomer = new CusNodeInsert(option).toAction();		
		ActionLazy<CusInfo> insertPerson = new ActionLazyCommom<CusInfo>(option, CusVisiNodePersonInsert.class);
		ActionLazy<CusInfo> snapshot = new ActionLazyCommom<CusInfo>(option, CusVisiNodeSnapshot.class);
		ActionLazy<CusInfo> insertAddress = new ActionLazyCommom<CusInfo>(option, CusVisiNodeAddressInsert.class);
		ActionLazy<CusInfo> insertPhone = new ActionLazyCommom<CusInfo>(option, CusVisiNodePhoneInsert.class);
		ActionLazy<CusInfo> select = new ActionLazyCommom<CusInfo>(option, CusVisiRootSelect.class);	
		
		insertCustomer.addPostAction(insertPerson);
		insertPerson.addPostAction(snapshot);
		snapshot.addPostAction(insertAddress);
		insertAddress.addPostAction(insertPhone);
		insertPhone.addPostAction(select);
		
		actions.add(insertCustomer);	
		return actions;
	}
}
