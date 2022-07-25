package br.com.mind5.masterData.languageSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.action.LangarchVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class LangarchRootSelect extends DeciTreeTemplateRead<LangarchInfo> {
	
	public LangarchRootSelect(DeciTreeOption<LangarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<LangarchInfo> buildCheckerHook(DeciTreeOption<LangarchInfo> option) {
		List<ModelChecker<LangarchInfo>> queue = new ArrayList<>();		
		ModelChecker<LangarchInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<LangarchInfo>> buildActionsOnPassedHook(DeciTreeOption<LangarchInfo> option) {
		List<ActionStd<LangarchInfo>> actions = new ArrayList<>();
		
		ActionStd<LangarchInfo> select = new ActionStdCommom<LangarchInfo>(option, LangarchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
