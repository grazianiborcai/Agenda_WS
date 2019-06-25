package br.com.gda.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.action.LazyAddresnapMergeCountry;
import br.com.gda.business.addressSnapshot.model.action.LazyAddresnapMergeForm;
import br.com.gda.business.addressSnapshot.model.action.LazyAddresnapMergeState;
import br.com.gda.business.addressSnapshot.model.action.StdAddresnapSelect;
import br.com.gda.business.addressSnapshot.model.checker.AddresnapCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootAddresnapSelect extends DeciTreeReadTemplate<AddresnapInfo> {
	
	public RootAddresnapSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildDecisionCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		
		checker = new AddresnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnapInfo> select = new StdAddresnapSelect(option);		
		ActionLazy<AddresnapInfo> mergeForm = new LazyAddresnapMergeForm(option.conn, option.schemaName);
		ActionLazy<AddresnapInfo> mergeState = new LazyAddresnapMergeState(option.conn, option.schemaName);
		ActionLazy<AddresnapInfo> mergeCountry = new LazyAddresnapMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeForm);
		mergeForm.addPostAction(mergeState);
		mergeState.addPostAction(mergeCountry);
		
		actions.add(select);			
		return actions;
	}
}
