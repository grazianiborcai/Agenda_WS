package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckFlagDel;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeAddressUpsertdel extends DeciTreeTemplateWriteV2<AddressInfo> {
	
	public NodeAddressUpsertdel(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelCheckerV1<AddressInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckFlagDel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV2<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<AddressInfo> delete = new RootAddressDelete(option).toAction();
		
		actions.add(delete);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV2<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<AddressInfo> update = new RootAddressUpdate(option).toAction();	
		
		actions.add(update);	

		return actions;
	}
}
