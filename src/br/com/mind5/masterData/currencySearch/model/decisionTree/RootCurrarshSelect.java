package br.com.mind5.masterData.currencySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.masterData.currencySearch.model.action.StdCurrarshDaoSelect;
import br.com.mind5.masterData.currencySearch.model.checker.CurrarshCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCurrarshSelect extends DeciTreeTemplateRead<CurrarshInfo> {
	
	public RootCurrarshSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CurrarshInfo> buildCheckerHook(DeciTreeOption<CurrarshInfo> option) {
		List<ModelChecker<CurrarshInfo>> queue = new ArrayList<>();		
		ModelChecker<CurrarshInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CurrarshCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CurrarshInfo>> buildActionsOnPassedHook(DeciTreeOption<CurrarshInfo> option) {
		List<ActionStd<CurrarshInfo>> actions = new ArrayList<>();
		
		ActionStd<CurrarshInfo> select = new StdCurrarshDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
