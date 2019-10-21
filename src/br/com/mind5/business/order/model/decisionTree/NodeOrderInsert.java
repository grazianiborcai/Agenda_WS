package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedBy;
import br.com.mind5.business.order.model.action.LazyOrderEnforceCreatedOn;
import br.com.mind5.business.order.model.action.LazyOrderEnforceExtid;
import br.com.mind5.business.order.model.action.LazyOrderEnforceStatusCreated;
import br.com.mind5.business.order.model.action.LazyOrderEnforceUser;
import br.com.mind5.business.order.model.action.LazyOrderInsert;
import br.com.mind5.business.order.model.action.LazyOrderMergeCusarch;
import br.com.mind5.business.order.model.action.StdOrderMergeUsername;
import br.com.mind5.business.order.model.checker.OrderCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderInsert extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckInsert();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		//TODO: zerar Address e Phone - Somente aceitar no Place
		ActionStd<OrderInfo> mergeUsername = new StdOrderMergeUsername(option);	
		ActionLazy<OrderInfo> enforceUser = new LazyOrderEnforceUser(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeCusarch = new LazyOrderMergeCusarch(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceCreatedOn = new LazyOrderEnforceCreatedOn(option.conn, option.schemaName);			
		ActionLazy<OrderInfo> enforceCreatedBy = new LazyOrderEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceStatus = new LazyOrderEnforceStatusCreated(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insert = new LazyOrderInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceUser);
		enforceUser.addPostAction(mergeCusarch);
		mergeCusarch.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(enforceExtid);
		enforceExtid.addPostAction(enforceStatus);		
		enforceStatus.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
