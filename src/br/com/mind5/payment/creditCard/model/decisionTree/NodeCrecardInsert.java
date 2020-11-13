package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardDaoInsert;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardEnforceUpperCase;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckCrecarch;

public final class NodeCrecardInsert extends DeciTreeTemplateWriteV2<CrecardInfo> {
	
	public NodeCrecardInsert(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CrecardCheckCrecarch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV2<CrecardInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<CrecardInfo> insertMoip = new NodeCrecardInsertMoip(option).toAction();
		ActionLazy<CrecardInfo> enforceUpperCase = new LazyCrecardEnforceUpperCase(option.conn, option.schemaName);	
		ActionLazy<CrecardInfo> insertCrecard = new LazyCrecardDaoInsert(option.conn, option.schemaName);	
		
		insertMoip.addPostAction(enforceUpperCase);
		enforceUpperCase.addPostAction(insertCrecard);
		
		actions.add(insertMoip);		
		return actions;
	}
}
