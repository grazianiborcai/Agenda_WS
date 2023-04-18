package br.com.mind5.payment.payOrderSearch.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.action.PayordarchVisiEnforceWebhookKey;
import br.com.mind5.payment.payOrderSearch.model.action.PayordarchVisiMergeToSelect;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckLangu;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckOwner;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckReadWebhook;

public final class PayordarchRootSelectWebhook extends DeciTreeTemplateRead<PayordarchInfo> {
	
	public PayordarchRootSelectWebhook(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordarchInfo> buildCheckerHook(DeciTreeOption<PayordarchInfo> option) {
		List<ModelChecker<PayordarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordarchCheckReadWebhook(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordarchInfo> option) {
		List<ActionStd<PayordarchInfo>> actions = new ArrayList<>();		

		ActionStd <PayordarchInfo> enforceWebhookKey = new ActionStdCommom <PayordarchInfo>(option, PayordarchVisiEnforceWebhookKey.class);
		ActionLazy<PayordarchInfo> mergeToSelect     = new ActionLazyCommom<PayordarchInfo>(option, PayordarchVisiMergeToSelect.class);
		
		enforceWebhookKey.addPostAction(mergeToSelect);
		
		actions.add(enforceWebhookKey);		
		return actions;
	}
}
