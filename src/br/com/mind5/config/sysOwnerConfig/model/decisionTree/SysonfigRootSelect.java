package br.com.mind5.config.sysOwnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.action.SysonfigVisiMergeToSelect;
import br.com.mind5.config.sysOwnerConfig.model.checker.SysonfigCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SysonfigRootSelect extends DeciTreeTemplateRead<SysonfigInfo> {
	
	public SysonfigRootSelect(DeciTreeOption<SysonfigInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SysonfigInfo> buildCheckerHook(DeciTreeOption<SysonfigInfo> option) {
		List<ModelChecker<SysonfigInfo>> queue = new ArrayList<>();		
		ModelChecker<SysonfigInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysonfigCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SysonfigInfo>> buildActionsOnPassedHook(DeciTreeOption<SysonfigInfo> option) {
		List<ActionStd<SysonfigInfo>> actions = new ArrayList<>();
		
		ActionStd<SysonfigInfo> select = new ActionStdCommom<SysonfigInfo>(option, SysonfigVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
