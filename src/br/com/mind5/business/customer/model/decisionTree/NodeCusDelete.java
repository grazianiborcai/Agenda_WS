package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDaoDelete;
import br.com.mind5.business.customer.model.action.LazyCusDaoUpdate;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.business.customer.model.action.LazyCusNodeDeleteAddress;
import br.com.mind5.business.customer.model.action.LazyCusNodeDeletePhone;
import br.com.mind5.business.customer.model.action.LazyCusPersonDelete;
import br.com.mind5.business.customer.model.action.StdCusEnforceLChanged;
import br.com.mind5.business.customer.model.checker.CusCheckSytotauh;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusDelete extends DeciTreeTemplateWrite<CusInfo> {
	
	public NodeCusDelete(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckSytotauh(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazy<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazy<CusInfo> update = new LazyCusDaoUpdate(option.conn, option.schemaName);
		ActionLazy<CusInfo> deleteAddress = new LazyCusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> deletePhone = new LazyCusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<CusInfo> deletePerson = new LazyCusPersonDelete(option.conn, option.schemaName);
		ActionLazy<CusInfo> deleteCustomer = new LazyCusDaoDelete(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCustomer);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
