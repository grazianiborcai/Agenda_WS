package br.com.mind5.masterData.areaPhoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.masterData.areaPhoneSearch.model.action.AreanarchVisiDaoSelect;
import br.com.mind5.masterData.areaPhoneSearch.model.checker.AreanarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class AreanarchRootSelect extends DeciTreeTemplateRead<AreanarchInfo> {
	
	public AreanarchRootSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AreanarchInfo> buildCheckerHook(DeciTreeOption<AreanarchInfo> option) {
		List<ModelChecker<AreanarchInfo>> queue = new ArrayList<>();		
		ModelChecker<AreanarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreanarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<AreanarchInfo>> buildActionsOnPassedHook(DeciTreeOption<AreanarchInfo> option) {
		List<ActionStd<AreanarchInfo>> actions = new ArrayList<>();
		
		ActionStd<AreanarchInfo> select = new ActionStdCommom<AreanarchInfo>(option, AreanarchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
