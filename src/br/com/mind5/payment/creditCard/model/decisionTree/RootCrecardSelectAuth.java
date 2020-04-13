package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeCusparRefL1;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeUser;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDummy;

public final class RootCrecardSelectAuth extends DeciTreeTemplateReadV1<CrecardInfo> {
	
	public RootCrecardSelectAuth(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;

		checker = new CrecardCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CrecardInfo> select = new RootCrecardSelect(option).toAction();
		ActionLazyV1<CrecardInfo> user = new LazyCrecardNodeUser(option.conn, option.schemaName);
		ActionLazyV1<CrecardInfo> cusparRef = new LazyCrecardNodeCusparRefL1(option.conn, option.schemaName);
		
		select.addPostAction(user);
		user.addPostAction(cusparRef);
		
		actions.add(select);
		return actions;
	}
}
