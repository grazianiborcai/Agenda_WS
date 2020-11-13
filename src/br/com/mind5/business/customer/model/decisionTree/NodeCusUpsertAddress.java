package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusAddressUpsert;
import br.com.mind5.business.customer.model.action.StdCusEnforceAddressKey;
import br.com.mind5.business.customer.model.action.StdCusSuccess;
import br.com.mind5.business.customer.model.checker.CusCheckHasAddress;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCusUpsertAddress extends DeciTreeTemplateWriteV2<CusInfo> {
	
	public NodeCusUpsertAddress(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckHasAddress(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusInfo> enforceAddressKey = new StdCusEnforceAddressKey(option);
		ActionLazy<CusInfo> upsertAddress = new LazyCusAddressUpsert(option.conn, option.schemaName);
		
		enforceAddressKey.addPostAction(upsertAddress);
		
		actions.add(enforceAddressKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusInfo> success = new StdCusSuccess(option);
		
		actions.add(success);		
		return actions;
	}
}
