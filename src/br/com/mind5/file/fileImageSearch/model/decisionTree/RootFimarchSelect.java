package br.com.mind5.file.fileImageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.action.StdFimarchMergeToSelect;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckLangu;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckOwner;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFimarchSelect extends DeciTreeReadTemplate<FimarchInfo> {
	
	public RootFimarchSelect(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimarchInfo> buildDecisionCheckerHook(DeciTreeOption<FimarchInfo> option) {
		List<ModelChecker<FimarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FimarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FimarchInfo> option) {
		List<ActionStd<FimarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FimarchInfo> select = new StdFimarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
