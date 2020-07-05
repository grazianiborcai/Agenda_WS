package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusPersonInsert;
import br.com.mind5.business.customer.model.action.LazyCusDaoUpdate;
import br.com.mind5.business.customer.model.action.StdCusEnforcePersonKey;
import br.com.mind5.business.customer.model.checker.CusCheckHasPerson;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCusInsertPerson extends DeciTreeTemplateWriteV2<CusInfo> {
	
	public NodeCusInsertPerson(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CusCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusInfo> enforcePersonKey = new StdCusEnforcePersonKey(option);
		ActionLazyV1<CusInfo> insertPerson = new LazyCusPersonInsert(option.conn, option.schemaName);		
		ActionLazyV1<CusInfo> update = new LazyCusDaoUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(update);
		
		actions.add(enforcePersonKey);	
		return actions;
	}
}
