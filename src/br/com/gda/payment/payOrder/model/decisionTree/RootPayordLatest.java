package br.com.gda.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.action.LazyPayordFilterLatest;
import br.com.gda.payment.payOrder.model.action.LazyPayordMergeToSelect;
import br.com.gda.payment.payOrder.model.action.LazyPayordRootSelect;
import br.com.gda.payment.payOrder.model.action.StdPayordEnforceOrderKey;
import br.com.gda.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.gda.payment.payOrder.model.checker.PayordCheckLatest;
import br.com.gda.payment.payOrder.model.checker.PayordCheckUsername;

public final class RootPayordLatest extends DeciTreeReadTemplate<PayordInfo> {
	
	public RootPayordLatest(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildDecisionCheckerHook(DeciTreeOption<PayordInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordCheckLatest();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> enforceOrderKey = new StdPayordEnforceOrderKey(option);	
		ActionLazy<PayordInfo> mergeToSelect = new LazyPayordMergeToSelect(option.conn, option.schemaName);
		ActionLazy<PayordInfo> filterLatest = new LazyPayordFilterLatest(option.conn, option.schemaName);
		ActionLazy<PayordInfo> rootSelect = new LazyPayordRootSelect(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(filterLatest);
		filterLatest.addPostAction(rootSelect);
		
		actions.add(enforceOrderKey);		
		return actions;
	}
}
