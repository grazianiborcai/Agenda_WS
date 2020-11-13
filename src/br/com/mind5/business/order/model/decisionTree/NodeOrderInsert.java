package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderDaoInsert;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedBy;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedOn;
import br.com.mind5.business.order.model.action.LazyOrderEnforceExtid;
import br.com.mind5.business.order.model.action.LazyOrderEnforcePostingDate;
import br.com.mind5.business.order.model.action.LazyOrderMergeOrdugeCreate;
import br.com.mind5.business.order.model.action.LazyOrderMergeRefupown;
import br.com.mind5.business.order.model.action.LazyOrderNodeCusL1;
import br.com.mind5.business.order.model.action.StdOrderMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
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
	
	
	
	@Override protected List<ActionStdV2<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStdV2<OrderInfo>> actions = new ArrayList<>();
		//TODO: zerar Address e Phone - Somente aceitar no Place
		ActionStdV2<OrderInfo> mergeUsername = new StdOrderMergeUsername(option);	
		ActionLazy<OrderInfo> nodeCus = new LazyOrderNodeCusL1(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceCreatedOn = new LazyOrderEnforceCreatedOn(option.conn, option.schemaName);			
		ActionLazy<OrderInfo> enforceCreatedBy = new LazyOrderEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<OrderInfo> enforcePostingDate = new LazyOrderEnforcePostingDate(option.conn, option.schemaName);	
		ActionLazy<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazy<OrderInfo> statusChange = new LazyOrderMergeOrdugeCreate(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeRefupown = new LazyOrderMergeRefupown(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insert = new LazyOrderDaoInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(nodeCus);
		nodeCus.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(enforceExtid);
		enforceExtid.addPostAction(statusChange);		
		statusChange.addPostAction(mergeRefupown);
		mergeRefupown.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
