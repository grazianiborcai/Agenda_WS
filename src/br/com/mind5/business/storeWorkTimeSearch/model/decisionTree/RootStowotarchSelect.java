package br.com.mind5.business.storeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.action.StdStowotarchMergeToSelect;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckLangu;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckOwner;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckRead;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStowotarchSelect extends DeciTreeTemplateRead<StowotarchInfo> {
	
	public RootStowotarchSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotarchInfo> buildCheckerHook(DeciTreeOption<StowotarchInfo> option) {
		List<ModelChecker<StowotarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotarchInfo> option) {
		List<ActionStd<StowotarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotarchInfo> select = new StdStowotarchMergeToSelect(option);
		
		actions.add(select);		
		return actions; 
	}
}
