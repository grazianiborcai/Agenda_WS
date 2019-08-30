package br.com.gda.payment.payOrderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.model.action.LazyPayordarchFilterLatest;
import br.com.gda.payment.payOrderSearch.model.action.LazyPayordarchRootSelect;
import br.com.gda.payment.payOrderSearch.model.action.StdPayordarchEnforceOrderKey;
import br.com.gda.payment.payOrderSearch.model.checker.PayordarchCheckLatest;

public final class RootPayordarchLatest extends DeciTreeReadTemplate<PayordarchInfo> {
	
	public RootPayordarchLatest(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordarchInfo> buildDecisionCheckerHook(DeciTreeOption<PayordarchInfo> option) {
		List<ModelChecker<PayordarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordarchInfo> checker;	
		
		checker = new PayordarchCheckLatest();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<PayordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordarchInfo> option) {
		List<ActionStd<PayordarchInfo>> actions = new ArrayList<>();		

		ActionStd<PayordarchInfo> enforceOrderKey = new StdPayordarchEnforceOrderKey(option);
		ActionLazy<PayordarchInfo> select = new LazyPayordarchRootSelect(option.conn, option.schemaName);	
		ActionLazy<PayordarchInfo> filterLatest = new LazyPayordarchFilterLatest(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(select);
		select.addPostAction(filterLatest);
		
		actions.add(enforceOrderKey);		
		return actions;
	}
}
