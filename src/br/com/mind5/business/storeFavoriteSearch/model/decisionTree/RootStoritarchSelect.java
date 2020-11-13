package br.com.mind5.business.storeFavoriteSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeFavoriteSearch.model.action.StdStoritarchMergeToSelect;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckLangu;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckOwner;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStoritarchSelect extends DeciTreeTemplateWrite<StoritarchInfo> {
	
	public RootStoritarchSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoritarchInfo> buildCheckerHook(DeciTreeOption<StoritarchInfo> option) {
		List<ModelChecker<StoritarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StoritarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoritarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoritarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoritarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoritarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoritarchInfo> option) {
		List<ActionStd<StoritarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StoritarchInfo> select = new StdStoritarchMergeToSelect(option);
		
		actions.add(select);	
		return actions;
	}
}
