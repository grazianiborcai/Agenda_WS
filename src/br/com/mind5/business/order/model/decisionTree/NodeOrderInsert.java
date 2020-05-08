package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderDaoInsert;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedBy;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedOn;
import br.com.mind5.business.order.model.action.LazyOrderEnforceExtid;
import br.com.mind5.business.order.model.action.LazyOrderEnforcePostingDate;
import br.com.mind5.business.order.model.action.LazyOrderEnforceStatusCreated;
import br.com.mind5.business.order.model.action.LazyOrderMergeRefupown;
import br.com.mind5.business.order.model.action.LazyOrderNodeCusL1;
import br.com.mind5.business.order.model.action.StdOrderMergeUsername;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderInsert extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelCheckerV1<OrderInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV1<OrderInfo>> actions = new ArrayList<>();
		//TODO: zerar Address e Phone - Somente aceitar no Place
		ActionStdV1<OrderInfo> mergeUsername = new StdOrderMergeUsername(option);	
		ActionLazyV1<OrderInfo> nodeCus = new LazyOrderNodeCusL1(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> enforceCreatedOn = new LazyOrderEnforceCreatedOn(option.conn, option.schemaName);			
		ActionLazyV1<OrderInfo> enforceCreatedBy = new LazyOrderEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazyV1<OrderInfo> enforcePostingDate = new LazyOrderEnforcePostingDate(option.conn, option.schemaName);	
		ActionLazyV1<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> enforceStatus = new LazyOrderEnforceStatusCreated(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> mergeRefupown = new LazyOrderMergeRefupown(option.conn, option.schemaName);
		ActionLazyV1<OrderInfo> insert = new LazyOrderDaoInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(nodeCus);
		nodeCus.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(enforceExtid);
		enforceExtid.addPostAction(enforceStatus);		
		enforceStatus.addPostAction(mergeRefupown);
		mergeRefupown.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
