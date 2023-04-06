package br.com.mind5.payment.payOrderItemSearch.model.decisionTree;

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
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.action.PayormarchVisiEnforcePayordKey;
import br.com.mind5.payment.payOrderItemSearch.model.action.PayormarchVisiRootSelect;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckReadPayord;

public final class PayormarchRootSelectPayord extends DeciTreeTemplateWrite<PayormarchInfo> {
	
	public PayormarchRootSelectPayord(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayormarchInfo> buildCheckerHook(DeciTreeOption<PayormarchInfo> option) {
		List<ModelChecker<PayormarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayormarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayormarchCheckReadPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayormarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayormarchInfo> option) {
		List<ActionStd<PayormarchInfo>> actions = new ArrayList<>();
		
		ActionStd <PayormarchInfo> enforcePayordKey = new ActionStdCommom <PayormarchInfo>(option, PayormarchVisiEnforcePayordKey.class);
		ActionLazy<PayormarchInfo> select           = new ActionLazyCommom<PayormarchInfo>(option, PayormarchVisiRootSelect.class);
		
		enforcePayordKey.addPostAction(select);
		
		actions.add(enforcePayordKey);
		return actions;
	}
}
