package br.com.mind5.masterData.moonPhase.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.MoonaseVisiDaoSelect;
import br.com.mind5.masterData.moonPhase.model.checker.MoonaseCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MoonaseRootSelect extends DeciTreeTemplateRead<MoonaseInfo> {
	
	public MoonaseRootSelect(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MoonaseInfo> buildCheckerHook(DeciTreeOption<MoonaseInfo> option) {
		List<ModelChecker<MoonaseInfo>> queue = new ArrayList<>();		
		ModelChecker<MoonaseInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MoonaseCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MoonaseInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonaseInfo> option) {
		List<ActionStd<MoonaseInfo>> actions = new ArrayList<>();
		
		ActionStd<MoonaseInfo> select = new ActionStdCommom<MoonaseInfo>(option, MoonaseVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
