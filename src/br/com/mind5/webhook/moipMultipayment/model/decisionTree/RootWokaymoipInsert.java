package br.com.mind5.webhook.moipMultipayment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.model.action.LazyWokaymoipMergeDaemon;
import br.com.mind5.webhook.moipMultipayment.model.action.LazyWokaymoipPaytusRefresh;
import br.com.mind5.webhook.moipMultipayment.model.action.LazyWokaymoipSelect;
import br.com.mind5.webhook.moipMultipayment.model.action.LazyWokaymoipSuccess;
import br.com.mind5.webhook.moipMultipayment.model.action.StdWokaymoipEnforceIdPayment;
import br.com.mind5.webhook.moipMultipayment.model.checker.WokaymoipCheckInsert;

public final class RootWokaymoipInsert extends DeciTreeWriteTemplate<WokaymoipInfo> {
	
	public RootWokaymoipInsert(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WokaymoipInfo> buildDecisionCheckerHook(DeciTreeOption<WokaymoipInfo> option) {	
		List<ModelChecker<WokaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<WokaymoipInfo> checker;
		
		checker = new WokaymoipCheckInsert();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<WokaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<WokaymoipInfo> option) {
		List<ActionStd<WokaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<WokaymoipInfo> enforceIdPayment = new StdWokaymoipEnforceIdPayment(option);
		ActionLazy<WokaymoipInfo> select = new LazyWokaymoipSelect(option.conn, option.schemaName);
		ActionLazy<WokaymoipInfo> mergeDaemon = new LazyWokaymoipMergeDaemon(option.conn, option.schemaName);
		ActionLazy<WokaymoipInfo> paytusRefresh = new LazyWokaymoipPaytusRefresh(option.conn, option.schemaName);
		ActionLazy<WokaymoipInfo> success = new LazyWokaymoipSuccess(option.conn, option.schemaName);
		
		enforceIdPayment.addPostAction(select);
		select.addPostAction(mergeDaemon);
		mergeDaemon.addPostAction(paytusRefresh);
		paytusRefresh.addPostAction(success);
		
		actions.add(enforceIdPayment);		
		return actions;
	}
}
