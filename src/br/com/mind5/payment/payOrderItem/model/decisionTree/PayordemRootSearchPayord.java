package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.PayordemVisiEnforcePayordKey;
import br.com.mind5.payment.payOrderItem.model.action.PayordemVisiRootSearch;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckSearchPayord;

public final class PayordemRootSearchPayord extends DeciTreeTemplateWrite<PayordemInfo> {
	
	public PayordemRootSearchPayord(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemCheckSearchPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd <PayordemInfo> enforcePayordKey = new ActionStdCommom <PayordemInfo>(option, PayordemVisiEnforcePayordKey.class);
		ActionLazy<PayordemInfo> search           = new ActionLazyCommom<PayordemInfo>(option, PayordemVisiRootSearch.class);
		
		enforcePayordKey.addPostAction(search);
		
		actions.add(enforcePayordKey);
		return actions;
	}
}
