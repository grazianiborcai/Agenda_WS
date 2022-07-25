package br.com.mind5.masterData.prospectStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.action.ProstusVisiDaoSelect;
import br.com.mind5.masterData.prospectStatus.model.checker.ProstusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class ProstusRootSelect extends DeciTreeTemplateWrite<ProstusInfo> {
	
	public ProstusRootSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ProstusInfo> buildCheckerHook(DeciTreeOption<ProstusInfo> option) {
		List<ModelChecker<ProstusInfo>> queue = new ArrayList<>();		
		ModelChecker<ProstusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new ProstusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ProstusInfo>> buildActionsOnPassedHook(DeciTreeOption<ProstusInfo> option) {
		List<ActionStd<ProstusInfo>> actions = new ArrayList<>();
		
		ActionStd<ProstusInfo> select = new ActionStdCommom<ProstusInfo>(option, ProstusVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
