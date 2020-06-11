package br.com.mind5.masterData.fileDocTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.masterData.fileDocTypeSearch.model.action.StdFidocarchDaoSelect;
import br.com.mind5.masterData.fileDocTypeSearch.model.checker.FidocarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFidocarchSelect extends DeciTreeTemplateReadV2<FidocarchInfo> {
	
	public RootFidocarchSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FidocarchInfo> buildCheckerHook(DeciTreeOption<FidocarchInfo> option) {
		List<ModelCheckerV1<FidocarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FidocarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FidocarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FidocarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FidocarchInfo> option) {
		List<ActionStdV1<FidocarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FidocarchInfo> select = new StdFidocarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
