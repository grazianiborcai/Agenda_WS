package br.com.mind5.masterData.moonPhaseSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.masterData.moonPhaseSearch.model.action.MoonasarchVisiDaoSelect;
import br.com.mind5.masterData.moonPhaseSearch.model.checker.MoonasarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MoonasarchRootSelect extends DeciTreeTemplateRead<MoonasarchInfo> {
	
	public MoonasarchRootSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MoonasarchInfo> buildCheckerHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ModelChecker<MoonasarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MoonasarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MoonasarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MoonasarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonasarchInfo> option) {
		List<ActionStd<MoonasarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MoonasarchInfo> select = new ActionStdCommom<MoonasarchInfo>(option, MoonasarchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
