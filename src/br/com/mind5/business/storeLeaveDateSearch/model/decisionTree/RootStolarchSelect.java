package br.com.mind5.business.storeLeaveDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.action.StdStolarchMergeToSelect;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckLangu;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckOwner;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckRead;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootStolarchSelect extends DeciTreeReadTemplate<StolarchInfo> {
	
	public RootStolarchSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}	
	
	
	@Override protected ModelChecker<StolarchInfo> buildDecisionCheckerHook(DeciTreeOption<StolarchInfo> option) {
		List<ModelChecker<StolarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StolarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StolarchInfo> option) {
		List<ActionStdV1<StolarchInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStolarchMergeToSelect(option));
		return actions;
	}
}
