package br.com.mind5.business.orderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.action.OrdemistVisiRootSearch;
import br.com.mind5.business.orderItemList.model.action.OrdemistVisiEnforceOrderKey;
import br.com.mind5.business.orderItemList.model.checker.OrdemistCheckSearchByOrder;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemistRootSearchByOrder extends DeciTreeTemplateWrite<OrdemistInfo> {
	
	public OrdemistRootSearchByOrder(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemistInfo> buildCheckerHook(DeciTreeOption<OrdemistInfo> option) {
		List<ModelChecker<OrdemistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new OrdemistCheckSearchByOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemistInfo> option) {
		List<ActionStd<OrdemistInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemistInfo> enforceOrderKey = new ActionStdCommom<OrdemistInfo>(option, OrdemistVisiEnforceOrderKey.class);
		ActionLazy<OrdemistInfo> search = new ActionLazyCommom<OrdemistInfo>(option, OrdemistVisiRootSearch.class);
		
		enforceOrderKey.addPostAction(search);
		
		actions.add(enforceOrderKey);
		return actions;
	}
}
