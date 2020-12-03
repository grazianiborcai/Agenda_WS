package br.com.mind5.discount.discountStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.action.StdDisorarchMergeToSelect;
import br.com.mind5.discount.discountStoreSearch.model.checker.DisorarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDisorarchSelect extends DeciTreeTemplateRead<DisorarchInfo> {
	
	public RootDisorarchSelect(DeciTreeOption<DisorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisorarchInfo> buildCheckerHook(DeciTreeOption<DisorarchInfo> option) {
		List<ModelChecker<DisorarchInfo>> queue = new ArrayList<>();		
		ModelChecker<DisorarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new DisorarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<DisorarchInfo> option) {
		List<ActionStd<DisorarchInfo>> actions = new ArrayList<>();
		
		ActionStd<DisorarchInfo> select	= new StdDisorarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
