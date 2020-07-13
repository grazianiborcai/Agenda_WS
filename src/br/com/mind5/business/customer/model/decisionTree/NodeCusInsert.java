package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDaoInsert;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedBy;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedOn;
import br.com.mind5.business.customer.model.action.LazyCusMergeSytotauh;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.business.customer.model.action.StdCusEnforceLChanged;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCusInsert extends DeciTreeTemplateWriteV2<CusInfo> {

	public NodeCusInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();

		ActionStdV1<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazyV1<CusInfo> mergeLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);	
		ActionLazyV1<CusInfo> enforceCreatedBy = new LazyCusEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> enforceCreatedOn = new LazyCusEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> mergeSytotauh = new LazyCusMergeSytotauh(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> insertCustomer = new LazyCusDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertCustomer);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
