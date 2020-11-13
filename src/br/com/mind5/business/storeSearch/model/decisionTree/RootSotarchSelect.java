package br.com.mind5.business.storeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.action.StdSotarchMergeToSelect;
import br.com.mind5.business.storeSearch.model.checker.SotarchCheckLangu;
import br.com.mind5.business.storeSearch.model.checker.SotarchCheckOwner;
import br.com.mind5.business.storeSearch.model.checker.SotarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootSotarchSelect extends DeciTreeTemplateRead<SotarchInfo> {
	
	public RootSotarchSelect(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SotarchInfo> buildCheckerHook(DeciTreeOption<SotarchInfo> option) {
		List<ModelChecker<SotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<SotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SotarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SotarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SotarchInfo> option) {
		List<ActionStd<SotarchInfo>> actions = new ArrayList<>();

		ActionStd<SotarchInfo> select = new StdSotarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
