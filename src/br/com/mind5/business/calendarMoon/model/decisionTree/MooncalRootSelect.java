package br.com.mind5.business.calendarMoon.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.action.MooncalVisiMergeMoonase;
import br.com.mind5.business.calendarMoon.model.action.MooncalVisiMergeToSelect;
import br.com.mind5.business.calendarMoon.model.checker.MooncalCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MooncalRootSelect extends DeciTreeTemplateRead<MooncalInfo> {
	
	public MooncalRootSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MooncalInfo> buildCheckerHook(DeciTreeOption<MooncalInfo> option) {
		List<ModelChecker<MooncalInfo>> queue = new ArrayList<>();		
		ModelChecker<MooncalInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MooncalCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MooncalInfo>> buildActionsOnPassedHook(DeciTreeOption<MooncalInfo> option) {
		List<ActionStd<MooncalInfo>> actions = new ArrayList<>();
		
		ActionStd<MooncalInfo> mergeToSelect = new ActionStdCommom<MooncalInfo>(option, MooncalVisiMergeToSelect.class);
		ActionLazy<MooncalInfo>  mergeMoonase = new ActionLazyCommom<MooncalInfo>(option, MooncalVisiMergeMoonase.class);
		
		mergeToSelect.addPostAction(mergeMoonase);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
