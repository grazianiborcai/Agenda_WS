package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressRootSelect;
import br.com.mind5.business.address.model.action.StdAddressMergeAddarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootAddressSearch extends DeciTreeTemplateWrite<AddressInfo> {
	
	public RootAddressSearch(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelCheckerV1<AddressInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddressInfo> checker;	

		checker = new ModelCherckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV1<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddressInfo> mergeAddarch = new StdAddressMergeAddarch(option);		
		ActionLazyV1<AddressInfo> select = new LazyAddressRootSelect(option.conn, option.schemaName);
		
		mergeAddarch.addPostAction(select);
		
		actions.add(mergeAddarch);			
		return actions;
	}
}
