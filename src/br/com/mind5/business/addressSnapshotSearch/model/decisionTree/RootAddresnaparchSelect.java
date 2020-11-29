package br.com.mind5.business.addressSnapshotSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.addressSnapshotSearch.model.action.StdAddresnaparchMergeToSelect;
import br.com.mind5.business.addressSnapshotSearch.model.checker.AddresnaparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootAddresnaparchSelect extends DeciTreeTemplateWrite<AddresnaparchInfo> {
	
	public RootAddresnaparchSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnaparchInfo> buildCheckerHook(DeciTreeOption<AddresnaparchInfo> option) {
		List<ModelChecker<AddresnaparchInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnaparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnaparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnaparchInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnaparchInfo> option) {
		List<ActionStd<AddresnaparchInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddresnaparchInfo> select = new StdAddresnaparchMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
