package br.com.mind5.masterData.areaPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.masterData.areaPhone.model.action.AreaneVisiDaoSelect;
import br.com.mind5.masterData.areaPhone.model.checker.AreaneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class AreaneRootSelect extends DeciTreeTemplateRead<AreaneInfo> {
	
	public AreaneRootSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AreaneInfo> buildCheckerHook(DeciTreeOption<AreaneInfo> option) {
		List<ModelChecker<AreaneInfo>> queue = new ArrayList<>();		
		ModelChecker<AreaneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AreaneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<AreaneInfo>> buildActionsOnPassedHook(DeciTreeOption<AreaneInfo> option) {
		List<ActionStd<AreaneInfo>> actions = new ArrayList<>();
		
		ActionStd<AreaneInfo> select = new ActionStdCommom<AreaneInfo>(option, AreaneVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
