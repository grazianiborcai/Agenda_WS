package br.com.mind5.webhook.moipRefund.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdEmptifyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.model.action.WokefumoipVisiDaoSelect;
import br.com.mind5.webhook.moipRefund.model.action.WokefumoipVisiEnforceIdPayment;
import br.com.mind5.webhook.moipRefund.model.action.WokefumoipVisiMergeDaemon;
import br.com.mind5.webhook.moipRefund.model.action.WokefumoipVisiPaytusRefresh;
import br.com.mind5.webhook.moipRefund.model.checker.WokefumoipCheckInsert;

public final class WokefumoipRootInsert extends DeciTreeTemplateWrite<WokefumoipInfo> {
	
	public WokefumoipRootInsert(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WokefumoipInfo> buildCheckerHook(DeciTreeOption<WokefumoipInfo> option) {	
		List<ModelChecker<WokefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<WokefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WokefumoipCheckInsert(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<WokefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<WokefumoipInfo> option) {
		List<ActionStd<WokefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<WokefumoipInfo> enforceIdPayment = new ActionStdCommom<WokefumoipInfo>(option, WokefumoipVisiEnforceIdPayment.class);
		ActionLazy<WokefumoipInfo> select = new ActionLazyCommom<WokefumoipInfo>(option, WokefumoipVisiDaoSelect.class);
		ActionLazy<WokefumoipInfo> mergeDaemon = new ActionLazyCommom<WokefumoipInfo>(option, WokefumoipVisiMergeDaemon.class);
		ActionLazy<WokefumoipInfo> paytusRefresh = new ActionLazyCommom<WokefumoipInfo>(option, WokefumoipVisiPaytusRefresh.class);
		ActionStd<WokefumoipInfo> emptify = new ActionStdEmptifyCommom<WokefumoipInfo>(WokefumoipInfo.class);
		
		enforceIdPayment.addPostAction(select);
		select.addPostAction(mergeDaemon);
		mergeDaemon.addPostAction(paytusRefresh);
		
		actions.add(enforceIdPayment);
		actions.add(emptify);
		
		return actions;
	}
}
