package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiNodeAddressUpsert;
import br.com.mind5.business.customer.model.action.CusVisiNodePersonUpdate;
import br.com.mind5.business.customer.model.action.CusVisiNodePhoneUpsert;
import br.com.mind5.business.customer.model.action.CusVisiNodeSnapshot;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusRootUpdate extends DeciTreeTemplateWrite<CusInfo> {
	
	public CusRootUpdate(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> updateCustomer = new CusNodeUpdate(option).toAction();	
		ActionLazy<CusInfo> updatePerson = new ActionLazyCommom<CusInfo>(option, CusVisiNodePersonUpdate.class);		
		ActionLazy<CusInfo> snapshot = new ActionLazyCommom<CusInfo>(option, CusVisiNodeSnapshot.class);	
		ActionLazy<CusInfo> upsertAddress = new ActionLazyCommom<CusInfo>(option, CusVisiNodeAddressUpsert.class);	
		ActionLazy<CusInfo> upsertPhone = new ActionLazyCommom<CusInfo>(option, CusVisiNodePhoneUpsert.class);		
		ActionStd<CusInfo> select = new CusRootSelect(option).toAction();	
		
		updateCustomer.addPostAction(updatePerson);	
		updatePerson.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);
		snapshot.addPostAction(upsertPhone);
		
		actions.add(updateCustomer);
		actions.add(select);	
		return actions;
	}
}
