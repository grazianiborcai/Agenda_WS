package br.com.mind5.masterData.fileDocTypeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.masterData.fileDocTypeSearch.model.action.StdFidocarchDaoSelect;
import br.com.mind5.masterData.fileDocTypeSearch.model.checker.FidocarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFidocarchSelect extends DeciTreeTemplateRead<FidocarchInfo> {
	
	public RootFidocarchSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FidocarchInfo> buildCheckerHook(DeciTreeOption<FidocarchInfo> option) {
		List<ModelChecker<FidocarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FidocarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FidocarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FidocarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FidocarchInfo> option) {
		List<ActionStd<FidocarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FidocarchInfo> select = new StdFidocarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
