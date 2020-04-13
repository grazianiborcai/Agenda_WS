package br.com.mind5.business.materialTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.action.StdMatextarchMergeToSelect;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckOwner;
import br.com.mind5.business.materialTextSearch.model.checker.MatextarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatextarchSelect extends DeciTreeTemplateReadV1<MatextarchInfo> {
	
	public RootMatextarchSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextarchInfo> buildCheckerHook(DeciTreeOption<MatextarchInfo> option) {
		List<ModelCheckerV1<MatextarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextarchInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextarchInfo> option) {
		List<ActionStdV1<MatextarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextarchInfo> select = new StdMatextarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
