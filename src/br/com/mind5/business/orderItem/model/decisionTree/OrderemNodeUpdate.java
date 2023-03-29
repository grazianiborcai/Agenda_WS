package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiEnforceLChanged;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeUsername;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeSnapshot;
import br.com.mind5.business.orderItem.model.action.OrderemVisiStusorageUpsert;
import br.com.mind5.business.orderItem.model.action.OrderemVisiStusorygeUpsert;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeUpdate extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeUpdate(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrderemCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();

		ActionStd <OrderemInfo> mergeUsername   = new ActionStdCommom <OrderemInfo>(option, OrderemVisiMergeUsername.class);
		ActionLazy<OrderemInfo> enforceLChanged = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiEnforceLChanged.class);
		ActionLazy<OrderemInfo> snapshot        = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeSnapshot.class);
		ActionLazy<OrderemInfo> stusorageUpsert = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiStusorageUpsert.class);
		ActionLazy<OrderemInfo> stusorygeUpsert = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiStusorygeUpsert.class);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(snapshot);
		snapshot.addPostAction(stusorageUpsert);
		stusorageUpsert.addPostAction(stusorygeUpsert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
