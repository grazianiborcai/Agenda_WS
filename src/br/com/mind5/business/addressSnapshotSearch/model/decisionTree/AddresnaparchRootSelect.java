package br.com.mind5.business.addressSnapshotSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.business.addressSnapshotSearch.model.action.AddresnaparchVisiMergeToSelect;
import br.com.mind5.business.addressSnapshotSearch.model.checker.AddresnaparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddresnaparchRootSelect extends DeciTreeTemplateWrite<AddresnaparchInfo> {
	
	public AddresnaparchRootSelect(DeciTreeOption<AddresnaparchInfo> option) {
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
		
		ActionStd<AddresnaparchInfo> select = new ActionStdCommom<AddresnaparchInfo>(option, AddresnaparchVisiMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}
