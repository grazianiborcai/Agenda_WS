package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.OrderVisiDaoInsert;
import br.com.mind5.business.order.model.action.OrderVisiEnforceCreatedBy;
import br.com.mind5.business.order.model.action.OrderVisiEnforceCreatedOn;
import br.com.mind5.business.order.model.action.OrderVisiEnforceExtid;
import br.com.mind5.business.order.model.action.OrderVisiEnforcePostingDate;
import br.com.mind5.business.order.model.action.OrderVisiMergeOrdugeCreate;
import br.com.mind5.business.order.model.action.OrderVisiMergeRefupown;
import br.com.mind5.business.order.model.action.OrderVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderNodeInsert extends DeciTreeTemplateWrite<OrderInfo> {
	
	public OrderNodeInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		//TODO: zerar Address e Phone - Somente aceitar no Place
		ActionStd<OrderInfo> mergeUsername = new ActionStdCommom<OrderInfo>(option, OrderVisiMergeUsername.class);			
		ActionLazy<OrderInfo> enforceCreatedOn = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceCreatedOn.class);			
		ActionLazy<OrderInfo> enforceCreatedBy = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceCreatedBy.class);	
		ActionLazy<OrderInfo> enforcePostingDate = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforcePostingDate.class);	
		ActionLazy<OrderInfo> enforceExtid = new ActionLazyCommom<OrderInfo>(option, OrderVisiEnforceExtid.class);
		ActionLazy<OrderInfo> statusChange = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeOrdugeCreate.class);
		ActionLazy<OrderInfo> mergeRefupown = new ActionLazyCommom<OrderInfo>(option, OrderVisiMergeRefupown.class);
		ActionLazy<OrderInfo> insert = new ActionLazyCommom<OrderInfo>(option, OrderVisiDaoInsert.class);
		
		mergeUsername.addPostAction(enforceCreatedOn);
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
