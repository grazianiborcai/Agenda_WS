package br.com.mind5.webhook.moipMultipayment.model.decisionTree;

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
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.model.action.WokaymoipVisiDaoSelect;
import br.com.mind5.webhook.moipMultipayment.model.action.WokaymoipVisiEnforceIdPayment;
import br.com.mind5.webhook.moipMultipayment.model.action.WokaymoipVisiMergeDaemon;
import br.com.mind5.webhook.moipMultipayment.model.action.WokaymoipVisiPaytusRefresh;
import br.com.mind5.webhook.moipMultipayment.model.checker.WokaymoipCheckInsert;

public final class WokaymoipRootInsert extends DeciTreeTemplateWrite<WokaymoipInfo> {
	
	public WokaymoipRootInsert(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WokaymoipInfo> buildCheckerHook(DeciTreeOption<WokaymoipInfo> option) {	
		List<ModelChecker<WokaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<WokaymoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WokaymoipCheckInsert(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<WokaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<WokaymoipInfo> option) {
		List<ActionStd<WokaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<WokaymoipInfo> enforceIdPayment = new ActionStdCommom<WokaymoipInfo>(option, WokaymoipVisiEnforceIdPayment.class);
		ActionLazy<WokaymoipInfo> select = new ActionLazyCommom<WokaymoipInfo>(option, WokaymoipVisiDaoSelect.class);
		ActionLazy<WokaymoipInfo> mergeDaemon = new ActionLazyCommom<WokaymoipInfo>(option, WokaymoipVisiMergeDaemon.class);
		ActionLazy<WokaymoipInfo> paytusRefresh = new ActionLazyCommom<WokaymoipInfo>(option, WokaymoipVisiPaytusRefresh.class);
		ActionStd<WokaymoipInfo> emptify = new ActionStdEmptifyCommom<WokaymoipInfo>(WokaymoipInfo.class);
		
		enforceIdPayment.addPostAction(select);
		select.addPostAction(mergeDaemon);
		mergeDaemon.addPostAction(paytusRefresh);
		
		actions.add(enforceIdPayment);
		actions.add(emptify);
		
		return actions;
	}
}
