package br.com.mind5.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.action.LazyOrderEnforceUser;
import br.com.mind5.business.order.model.action.LazyOrderMergeUsername;
import br.com.mind5.business.order.model.action.LazyOrderNodeAuthL2;
import br.com.mind5.business.order.model.action.StdOrderEnforceKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeOrderAuthL1 extends DeciTreeTemplateWriteV2<OrderInfo> {
	
	public NodeOrderAuthL1(DeciTreeOption<OrderInfo> option) {
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
		
		ActionStdV2<OrderInfo> enforceKey = new StdOrderEnforceKey(option);
		ActionLazy<OrderInfo> mergeUsername = new LazyOrderMergeUsername(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceUser = new LazyOrderEnforceUser(option.conn, option.schemaName);
		ActionLazy<OrderInfo> nodeL2 = new LazyOrderNodeAuthL2(option.conn, option.schemaName);
		
		enforceKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceUser);
		enforceUser.addPostAction(nodeL2);
		
		actions.add(enforceKey);
		return actions;
	}
}
