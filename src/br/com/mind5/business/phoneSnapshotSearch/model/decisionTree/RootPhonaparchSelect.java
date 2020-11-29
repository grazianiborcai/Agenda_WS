package br.com.mind5.business.phoneSnapshotSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.business.phoneSnapshotSearch.model.action.StdPhonaparchMergeToSelect;
import br.com.mind5.business.phoneSnapshotSearch.model.checker.PhonaparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPhonaparchSelect extends DeciTreeTemplateRead<PhonaparchInfo> {

	public RootPhonaparchSelect(DeciTreeOption<PhonaparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonaparchInfo> buildCheckerHook(DeciTreeOption<PhonaparchInfo> option) {
		List<ModelChecker<PhonaparchInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonaparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonaparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonaparchInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonaparchInfo> option) {
		List<ActionStd<PhonaparchInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonaparchInfo> mergeToSelect = new StdPhonaparchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		
		return actions;
	}
}
