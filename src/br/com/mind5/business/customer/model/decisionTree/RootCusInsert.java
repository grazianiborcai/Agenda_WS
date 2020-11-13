package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertUserL1;
import br.com.mind5.business.customer.model.action.LazyCusRootInsertSilent;
import br.com.mind5.business.customer.model.action.LazyCusRootSelect;
import br.com.mind5.business.customer.model.action.StdCusEnforceUserCod;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCusInsert extends DeciTreeTemplateWriteV2<CusInfo> {

	public RootCusInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;		

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV2<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CusInfo> obfuscateUser = new StdCusEnforceUserCod(option);
		ActionLazy<CusInfo> insert = new LazyCusRootInsertSilent(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertUser = new LazyCusNodeInsertUserL1(option.conn, option.schemaName);				
		ActionLazy<CusInfo> select = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		obfuscateUser.addPostAction(insert);
		insert.addPostAction(insertUser);
		insertUser.addPostAction(select);
		
		actions.add(obfuscateUser);	
		return actions;
	}
}
