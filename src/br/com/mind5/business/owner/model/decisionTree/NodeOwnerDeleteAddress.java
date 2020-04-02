package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerDeleteAddress;
import br.com.mind5.business.owner.model.action.StdOwnerEnforceAddressKey;
import br.com.mind5.business.owner.model.action.StdOwnerSuccess;
import br.com.mind5.business.owner.model.checker.OwnerCheckHasAddress;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerDeleteAddress extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerDeleteAddress(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		final boolean HAS_ADDRESS = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_ADDRESS;		
		checker = new OwnerCheckHasAddress(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerInfo> enforceAddressKey = new StdOwnerEnforceAddressKey(option);
		ActionLazyV1<OwnerInfo> deleteAddress = new LazyOwnerDeleteAddress(option.conn, option.schemaName);
		
		enforceAddressKey.addPostAction(deleteAddress);
		
		actions.add(enforceAddressKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnFailedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();
		
		actions.add(new StdOwnerSuccess(option));		
		return actions;
	}
}
