package br.com.mind5.masterData.currencySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.masterData.currencySearch.model.action.StdCurrarshDaoSelect;
import br.com.mind5.masterData.currencySearch.model.checker.CurrarshCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCurrarshSelect extends DeciTreeTemplateReadV2<CurrarshInfo> {
	
	public RootCurrarshSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CurrarshInfo> buildCheckerHook(DeciTreeOption<CurrarshInfo> option) {
		List<ModelCheckerV1<CurrarshInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CurrarshInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CurrarshCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CurrarshInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrarshInfo> option) {
		List<ActionStdV1<CurrarshInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CurrarshInfo> select = new StdCurrarshDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
