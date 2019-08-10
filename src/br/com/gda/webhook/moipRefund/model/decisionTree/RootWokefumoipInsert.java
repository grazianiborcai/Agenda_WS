package br.com.gda.webhook.moipRefund.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;
import br.com.gda.webhook.moipRefund.model.action.LazyWokefumoipMergeDaemon;
import br.com.gda.webhook.moipRefund.model.action.LazyWokefumoipPaytusRefresh;
import br.com.gda.webhook.moipRefund.model.action.LazyWokefumoipSelect;
import br.com.gda.webhook.moipRefund.model.action.LazyWokefumoipSuccess;
import br.com.gda.webhook.moipRefund.model.action.StdWokefumoipEnforceIdPayment;
import br.com.gda.webhook.moipRefund.model.checker.WokefumoipCheckInsert;

public final class RootWokefumoipInsert extends DeciTreeWriteTemplate<WokefumoipInfo> {
	
	public RootWokefumoipInsert(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WokefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<WokefumoipInfo> option) {	
		List<ModelChecker<WokefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<WokefumoipInfo> checker;
		
		checker = new WokefumoipCheckInsert();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<WokefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<WokefumoipInfo> option) {
		List<ActionStd<WokefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<WokefumoipInfo> enforceIdPayment = new StdWokefumoipEnforceIdPayment(option);
		ActionLazy<WokefumoipInfo> select = new LazyWokefumoipSelect(option.conn, option.schemaName);
		ActionLazy<WokefumoipInfo> mergeDaemon = new LazyWokefumoipMergeDaemon(option.conn, option.schemaName);
		ActionLazy<WokefumoipInfo> paytusRefresh = new LazyWokefumoipPaytusRefresh(option.conn, option.schemaName);
		ActionLazy<WokefumoipInfo> success = new LazyWokefumoipSuccess(option.conn, option.schemaName);
		
		enforceIdPayment.addPostAction(select);
		select.addPostAction(mergeDaemon);
		mergeDaemon.addPostAction(paytusRefresh);
		paytusRefresh.addPostAction(success);
		
		actions.add(enforceIdPayment);		
		return actions;
	}
}
