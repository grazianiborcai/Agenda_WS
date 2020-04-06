package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDeletePhone;
import br.com.mind5.business.owner.model.action.StdOwnerEnforcePhoneKey;
import br.com.mind5.business.owner.model.action.StdOwnerSuccess;
import br.com.mind5.business.owner.model.checker.OwnerCheckHasPhone;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOwnerDeletePhone extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public NodeOwnerDeletePhone(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		final boolean HAS_PHONE = true;
		
		List<ModelCheckerV1<OwnerInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PHONE;		
		checker = new OwnerCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforcePhoneKey = new StdOwnerEnforcePhoneKey(option);
		ActionLazyV1<OwnerInfo> deletePhone = new LazyOwnerDeletePhone(option.conn, option.schemaName);
		
		enforcePhoneKey.addPostAction(deletePhone);
		
		actions.add(enforcePhoneKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnFailedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		actions.add(new StdOwnerSuccess(option));		
		return actions;
	}
}
