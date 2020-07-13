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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCusDelete extends DeciTreeTemplateWriteV2<CusInfo> {
	
	public NodeCusDelete(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckSytotauh(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();

		ActionStdV1<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazyV1<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> update = new LazyCusDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deleteAddress = new LazyCusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deletePhone = new LazyCusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deletePerson = new LazyCusPersonDelete(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> deleteCustomer = new LazyCusDaoDelete(option.conn, option.schemaName);	
		
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
