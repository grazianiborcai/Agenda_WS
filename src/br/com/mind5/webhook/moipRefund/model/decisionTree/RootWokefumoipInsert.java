package br.com.mind5.webhook.moipRefund.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.model.action.LazyWokefumoipMergeDaemon;
import br.com.mind5.webhook.moipRefund.model.action.LazyWokefumoipPaytusRefresh;
import br.com.mind5.webhook.moipRefund.model.action.LazyWokefumoipSelect;
import br.com.mind5.webhook.moipRefund.model.action.LazyWokefumoipSuccess;
import br.com.mind5.webhook.moipRefund.model.action.StdWokefumoipEnforceIdPayment;
import br.com.mind5.webhook.moipRefund.model.checker.WokefumoipCheckInsert;

public final class RootWokefumoipInsert extends DeciTreeTemplateWriteV1<WokefumoipInfo> {
	
	public RootWokefumoipInsert(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<WokefumoipInfo> buildCheckerHook(DeciTreeOption<WokefumoipInfo> option) {	
		List<ModelCheckerV1<WokefumoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<WokefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WokefumoipCheckInsert(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<WokefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<WokefumoipInfo> option) {
		List<ActionStdV1<WokefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<WokefumoipInfo> enforceIdPayment = new StdWokefumoipEnforceIdPayment(option);
		ActionLazyV1<WokefumoipInfo> select = new LazyWokefumoipSelect(option.conn, option.schemaName);
		ActionLazyV1<WokefumoipInfo> mergeDaemon = new LazyWokefumoipMergeDaemon(option.conn, option.schemaName);
		ActionLazyV1<WokefumoipInfo> paytusRefresh = new LazyWokefumoipPaytusRefresh(option.conn, option.schemaName);
		ActionLazyV1<WokefumoipInfo> success = new LazyWokefumoipSuccess(option.conn, option.schemaName);
		
		enforceIdPayment.addPostAction(select);
		select.addPostAction(mergeDaemon);
		mergeDaemon.addPostAction(paytusRefresh);
		paytusRefresh.addPostAction(success);
		
		actions.add(enforceIdPayment);		
		return actions;
	}
}
