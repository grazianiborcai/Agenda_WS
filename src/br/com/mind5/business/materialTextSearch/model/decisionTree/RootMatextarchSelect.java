package br.com.mind5.business.materialTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.action.StdMatextarchMergeToSelect;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckOwner;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatextarchSelect extends DeciTreeReadTemplate<MatextarchInfo> {
	
	public RootMatextarchSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextarchInfo> buildCheckerHook(DeciTreeOption<MatextarchInfo> option) {
		List<ModelChecker<MatextarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextarchCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextarchCheckOwner(checkerOption);
		queue.add(checker);			
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextarchInfo> option) {
		List<ActionStdV1<MatextarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextarchInfo> select = new StdMatextarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
