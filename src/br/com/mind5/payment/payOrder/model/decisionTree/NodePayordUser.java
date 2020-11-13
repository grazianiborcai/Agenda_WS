package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordEnforceLChanged;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeUsername;
import br.com.mind5.payment.payOrder.model.action.StdPayordEnforceCreatedOn;

public final class NodePayordUser extends DeciTreeTemplateWrite<PayordInfo> {
	
	public NodePayordUser(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> enforceCreatedOn = new StdPayordEnforceCreatedOn(option);	
		ActionLazy<PayordInfo> enforceLChanged = new LazyPayordEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergeUsername = new LazyPayordMergeUsername(option.conn, option.schemaName);
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		
		actions.add(enforceCreatedOn);		
		return actions;
	}
}
