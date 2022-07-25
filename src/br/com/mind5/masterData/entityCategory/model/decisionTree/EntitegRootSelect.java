package br.com.mind5.masterData.entityCategory.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.action.EntitegVisiDaoSelect;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EntitegRootSelect extends DeciTreeTemplateRead<EntitegInfo> {
	
	public EntitegRootSelect(DeciTreeOption<EntitegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EntitegInfo> buildCheckerHook(DeciTreeOption<EntitegInfo> option) {
		List<ModelChecker<EntitegInfo>> queue = new ArrayList<>();		
		ModelChecker<EntitegInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EntitegCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<EntitegInfo>> buildActionsOnPassedHook(DeciTreeOption<EntitegInfo> option) {
		List<ActionStd<EntitegInfo>> actions = new ArrayList<>();
		
		ActionStd<EntitegInfo> select = new ActionStdCommom<EntitegInfo>(option, EntitegVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
