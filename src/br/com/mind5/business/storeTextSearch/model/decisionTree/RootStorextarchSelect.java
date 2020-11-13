package br.com.mind5.business.storeTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.action.StdStorextarchMergeToSelect;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckOwner;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStorextarchSelect extends DeciTreeTemplateRead<StorextarchInfo> {
	
	public RootStorextarchSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextarchInfo> buildCheckerHook(DeciTreeOption<StorextarchInfo> option) {
		List<ModelChecker<StorextarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextarchCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextarchCheckOwner(checkerOption);
		queue.add(checker);			
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextarchInfo> option) {
		List<ActionStd<StorextarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextarchInfo> select = new StdStorextarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
