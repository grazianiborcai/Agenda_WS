package br.com.mind5.masterData.feeCategorySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.masterData.feeCategorySearch.model.action.FeecatarchVisiDaoSelect;
import br.com.mind5.masterData.feeCategorySearch.model.checker.FeecatarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FeecatarchRootSelect extends DeciTreeTemplateRead<FeecatarchInfo> {
	
	public FeecatarchRootSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeecatarchInfo> buildCheckerHook(DeciTreeOption<FeecatarchInfo> option) {
		List<ModelChecker<FeecatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<FeecatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeecatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<FeecatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FeecatarchInfo> option) {
		List<ActionStd<FeecatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<FeecatarchInfo> select = new ActionStdCommom<FeecatarchInfo>(option, FeecatarchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
