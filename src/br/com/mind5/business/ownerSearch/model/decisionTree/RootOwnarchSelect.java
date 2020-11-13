package br.com.mind5.business.ownerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.action.StdOwnarchMergeToSelect;
import br.com.mind5.business.ownerSearch.model.checker.OwnarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOwnarchSelect extends DeciTreeTemplateRead<OwnarchInfo> {

	public RootOwnarchSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnarchInfo> buildCheckerHook(DeciTreeOption<OwnarchInfo> option) {
		List<ModelChecker<OwnarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnarchInfo> option) {
		List<ActionStd<OwnarchInfo>> actions = new ArrayList<>();

		ActionStd<OwnarchInfo> select = new StdOwnarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
	